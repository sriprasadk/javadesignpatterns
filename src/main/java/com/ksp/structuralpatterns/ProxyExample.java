package com.ksp.structuralpatterns;

/*
 * The Proxy pattern provides a surrogate or placeholder for another object to control access to it
 */
//Interface
interface Internet {
 void connectTo(String serverHost) throws Exception;
}

//Real implementation
class RealInternet implements Internet {
 @Override
 public void connectTo(String serverHost) throws Exception {
     System.out.println("Connecting to " + serverHost);
 }
}

//Proxy
class ProxyInternet implements Internet {
 private Internet realInternet;
 private static final String[] restrictedSites = {"blockedSite1.com", "blockedSite2.com"};

 public ProxyInternet() {
     this.realInternet = new RealInternet();
 }

 @Override
 public void connectTo(String serverHost) throws Exception {
     if (checkAccess(serverHost)) {
         realInternet.connectTo(serverHost);
     } else {
         throw new Exception("Access Denied: Cannot connect to " + serverHost);
     }
 }

 private boolean checkAccess(String serverHost) {
     for (String site : restrictedSites) {
         if (site.equals(serverHost)) {
             return false;
         }
     }
     return true;
 }
}

//Client
public class ProxyExample {
 public static void main(String[] args) {
     Internet internet = new ProxyInternet();

     try {
         internet.connectTo("allowedSite.com");
         internet.connectTo("blockedSite1.com");
     } catch (Exception e) {
         System.out.println(e.getMessage());
     }
 }
}

