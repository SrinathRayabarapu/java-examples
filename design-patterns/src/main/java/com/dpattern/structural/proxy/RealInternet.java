package com.dpattern.structural.proxy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RealInternet implements IInternet {

	@Override
	public void connectTo(String site) {
		log.info("Connecting to site.. {}", site);
	}

}
