package com.debuggeandoideas;

import com.debuggeandoideas.configs.StoneConfigs;
import com.debuggeandoideas.configs.TomcatConfig;
import com.debuggeandoideas.services.GauntletService;
import com.debuggeandoideas.services.GauntletServiceImpl;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) throws LifecycleException {

        final AnnotationConfigApplicationContext applicationContext
                = new AnnotationConfigApplicationContext(TomcatConfig.class);

        final Tomcat tomcat = applicationContext.getBean(Tomcat.class);

        tomcat.start();


       /* final AnnotationConfigApplicationContext applicationContext
                = new AnnotationConfigApplicationContext(StoneConfigs.class);

        final GauntletServiceImpl gauntletService =
                applicationContext.getBean(GauntletServiceImpl.class);

        gauntletService.useFullPower();
        gauntletService.useGauntlet("time");*/

        /*final ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("stones.xml");

        final GauntletServiceImpl gauntletService =
                applicationContext.getBean("gauntlet", GauntletServiceImpl.class);

        gauntletService.useGauntlet("reality");
        gauntletService.useGauntlet("power");*/

        /*
        * Load all beans by eager
        *  Implementation of IoC supports events, internalisation, configurable and advanced management of beans
        *  Annotation @ComponentScan and @Configuration
         */
        //final ApplicationContext applicationContext =
        //        new ClassPathXmlApplicationContext("stones.xml");

        /*
         * Load bean by bean lazy
         * Basic implementation od IoC
         */
      // final BeanFactory beanFactory =
      //         new ClassPathXmlApplicationContext("stones.xml");




        /*final MindStone mind = applicationContext.getBean("mind", MindStone.class);
        final PowerStone power = applicationContext.getBean("power", PowerStone.class);
        final RealityStone reality = applicationContext.getBean("reality", RealityStone.class);
        final SoulStone soul = applicationContext.getBean("soul", SoulStone.class);
        final SpaceStone space = applicationContext.getBean("space", SpaceStone.class);
        final TimeStone time = applicationContext.getBean("time", TimeStone.class);

        final GauntletService gauntletService = new GauntletServiceImpl(
                reality, soul, mind, power, space, time
        );

        gauntletService.useFullPower();

        gauntletService.useGauntlet("mind");



        //applicationContext.close();*/
    }
}