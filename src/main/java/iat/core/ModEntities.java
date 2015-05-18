package iat.core;

import iat.ConfigOptions;
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
		if(!ConfigOptions.disableTrilobite){
			EntityHandler.registerSpawnable(EntityTrilobite.class, "iat.trilobite", 0X80513C, 0X8A4C31);

		}
		if(!ConfigOptions.disableCompsognathus){
			EntityHandler.registerSpawnable(EntityCompsognathus.class, "iat.compsognathus", 0X6D7021, 0XB79D49);

		}
		if(!ConfigOptions.disableCarnotaurus){
			EntityHandler.registerSpawnable(EntityCarnotaurus.class, "iat.carnotaurus", 0XBC9A67, 0X6C0102);

		}
		if(!ConfigOptions.disableVelociraptor){
			EntityHandler.registerSpawnable(EntityVelociraptor.class, "iat.velociraptor", 0X746129, 0XCEC29C);

		}
		//EntityHandler.registerSpawnable(EntityTimeProtector.class, "iat.timeProtector", 0XFFFFFF, 0XFFFFFF);


	}
}
