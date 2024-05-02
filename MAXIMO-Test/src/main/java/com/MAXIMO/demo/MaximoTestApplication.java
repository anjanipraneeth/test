package com.MAXIMO.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class MaximoTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(MaximoTestApplication.class, args);
	}

    @Bean
    public MXSession mxSession() {
        return getConnection("192.168.18.128", 13400, "MXServer", "maxadmin", "maxadmin");
    }

    private MXSession getConnection(String host, int rmiPort, String serverName, String user, String pwd) {
        MXSession session = MXSession.getSession();

        String connHost = host + ":" + rmiPort + "/" + serverName;
        System.out.println("Connecting to " + connHost);

        session.setHost(connHost);
        session.setUserName(user);
        session.setPassword(pwd);

        try {
            session.connect();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        System.out.println("Connection OK");

        return session;
    }

    @Component
    public class MaximoService {

        private final MXSession mxSession;

        public MaximoService(MXSession mxSession) {
            this.mxSession = mxSession;
        }

        public void listAssets() {
            MboSetRemote assetMboSet = mxSession.getMboSet("ASSET");
            assetMboSet.setOrderBy("ASSETNUM");

            MboRemote assetMbo;
            for (int j = 0; ((assetMbo = assetMboSet.getMbo(j)) != null); j++) {
                String assetNum = assetMbo.getString("ASSETNUM");
                String location = assetMbo.getString("LOCATION");
                String desc = assetMbo.getString("DESCRIPTION");
                System.out.println(assetNum + " - " + location + " - " + desc);
            }
        }
    }
}
