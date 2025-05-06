package com.aaa;

import com.sun.management.OperatingSystemMXBean;

import java.lang.management.ManagementFactory;


public class CPURAMUsageMain {

    public static void main(String[] args) {
//        printUsage();
        OperatingSystemMXBean osBean = ManagementFactory.getPlatformMXBean(
                OperatingSystemMXBean.class);

        System.out.println(osBean.getCommittedVirtualMemorySize());
// Returns the amount of virtual memory that is guaranteed to be available to the running process in bytes, or -1 if this operation is not supported.

//        long getFreePhysicalMemorySize()
//// Returns the amount of free physical memory in bytes.
//
//        long getFreeSwapSpaceSize()
//// Returns the amount of free swap space in bytes.
//
//        double getProcessCpuLoad()
//// Returns the "recent cpu usage" for the Java Virtual Machine process.
//
//        long getProcessCpuTime()
//// Returns the CPU time used by the process on which the Java virtual machine is running in nanoseconds.
//
//        double getSystemCpuLoad()
//// Returns the "recent cpu usage" for the whole system.
//
//        long getTotalPhysicalMemorySize()
//// Returns the total amount of physical memory in bytes.
//
//        long getTotalSwapSpaceSize()
    }

   /* private static void printUsage() {
        OperatingSystemMXBean operatingSystemMXBean = ManagementFactory.getOperatingSystemMXBean();
        for (Method method : operatingSystemMXBean.getClass().getDeclaredMethods()) {
            method.setAccessible(true);
            if (method.getName().startsWith("get")
                    && Modifier.isPublic(method.getModifiers())) {
                Object value;
                try {
                    value = method.invoke(operatingSystemMXBean);
                } catch (Exception e) {
                    value = e;
                } // try
                System.out.println(method.getName() + " = " + value);
            } // if
        } // for
    }*/

}
