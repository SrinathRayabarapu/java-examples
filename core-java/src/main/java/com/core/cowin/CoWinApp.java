package com.core.cowin;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static com.core.cowin.HttpClient.sendGET;

public class CoWinApp {

    private static final String GET_URL = "https://cdn-api.co-vin.in/api/v2/appointment/sessions/public/calendarByPin?pincode=%s&date=%s";
    private static final int INTERVAL_TIME = 10;

    public static void main(String[] args) throws IOException {

        System.out.println(new Date() + " : CoWin app started");

//        System.out.println("Please enter your area pincode ?");
//        PINCODE = getUserInput();

        System.out.println(new Date() + " : Fetching free slot status for every " + INTERVAL_TIME + " seconds");

        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleAtFixedRate(() -> {
            try {
                checkCowinPortalFreeSlot();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }, 0, INTERVAL_TIME, TimeUnit.SECONDS);

    }

    private static String getUserInput() {
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }

    private static void checkCowinPortalFreeSlot() throws IOException {

        System.out.println(new Date() + " : Checking for free slot..");

        String[] pincodes = {"560066", "560067", "560049", "560103", "560037", "560076"};

        for(String pincode : pincodes){
            var url = String.format(GET_URL, pincode, fetchTodayDate());

            var response = sendGET(url);
//            System.out.println(new Date() + " : CoWin API polled : " + url);

//        String response = loadTestData();

            var mapper = new ObjectMapper();
            var apiResponse = mapper.readValue(response, APIResponse.class);

            FreeSlot freeSlot = findAFreeSlot(apiResponse);

            if(freeSlot != null) {
                System.out.println(new Date() + " : FOUND A FREE SLOT FOR PINCODE - " + freeSlot.getPincode());
                System.out.println(new Date() + " : Free slot details : " + mapper.writeValueAsString(freeSlot));
                splashScreen(freeSlot.getPincode());
            }
        }

    }

    private static void splashScreen(String pincode) throws MalformedURLException {

        JWindow window = new JWindow();
//        window.getContentPane().add(
//                new JLabel("Found!!", new ImageIcon(CoWinApp.class.getClassLoader().getResource("found.png")), SwingConstants.CENTER));
//        window.setBounds(500, 150, 300, 200);
//        window.setVisible(true);
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        window.setVisible(false);
        JFrame frame = new JFrame();
        JLabel jLabel = new JLabel("Found @ " + pincode, SwingConstants.CENTER);
        jLabel.setFont(new Font("Serif", Font.PLAIN, 80));

        frame.add(jLabel);
        frame.setVisible(true);
        frame.setSize(600,100);
        window.dispose();
    }

    private static FreeSlot findAFreeSlot(APIResponse apiResponse) {

        List<Optional<FreeSlot>> freeSlots = apiResponse.getCenters().stream().map(c ->
                c.getSessions().stream().filter(s ->
                        (s.getAvailable_capacity() > 0
                                && s.getMin_age_limit() == 18
                                && s.getAvailable_capacity_dose1() > 0)
                ).map(s -> convertToFreeSlot(s, c)).findAny()
        ).collect(Collectors.toList());

        for(Optional<FreeSlot> freeSlotOptional : freeSlots){
            if(freeSlotOptional.isPresent())
                return freeSlotOptional.get();
        }

        return null;
    }

    private static FreeSlot convertToFreeSlot(com.core.cowin.Session session, Center center) {
        var freeSlot = new FreeSlot();
        freeSlot.setName(center.getName());
        freeSlot.setAddress(center.getAddress());
        freeSlot.setStateName(center.getState_name());
        freeSlot.setDistrictName(center.getDistrict_name());
        freeSlot.setBlockName(center.getBlock_name());
        freeSlot.setPincode(center.getPincode());
        freeSlot.setMinAgeLimit(session.getMin_age_limit());
        freeSlot.setVaccine(session.getVaccine());
        freeSlot.setAvailableCapacity(session.getAvailable_capacity());
        freeSlot.setAvailableCapacityDose1(session.getAvailable_capacity_dose1());
        freeSlot.setAvailableCapacityDose2(session.getAvailable_capacity_dose2());
        freeSlot.setSlots(session.getSlots().toArray(new String[0]));
        freeSlot.setFrom(center.getFrom());
        freeSlot.setTo(center.getTo());
        return freeSlot;
    }

    public static String fetchTodayDate(){
        var date = new Date();
        var formatter = new SimpleDateFormat("dd-MM-yyyy");
        return formatter.format(date);
    }

    public static String loadTestData() throws IOException {
        var file = new File(CoWinApp.class.getClassLoader().getResource("cowin-test.data").getFile());
        return new String(Files.readAllBytes(file.toPath()));
    }

}
