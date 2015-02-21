package iat.core;

import iat.entities.mob.*;
import iat.misc.EntityHandler;

public class ModEntities {

	public static void init() {
		initializeEntities();
		register();
	}
	public static void initializeEntities(){

	}
	public static void register(){
		//EntityHandler.registerSpawnable(EntityJellyfish.class, "iat.jellyfish", 0XFEC4C4, 0XFFB27F);
		EntityHandler.registerSpawnable(EntityTrilobite.class, "iat.trilobite", 0X80513C, 0X8A4C31);
		EntityHandler.registerSpawnable(EntityCompsognathus.class, "iat.compsognathus", 0X6D7021, 0XB79D49);


	}
}
