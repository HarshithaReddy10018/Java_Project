package report;

import analyzer.WiFiAnalyzer;

public class ReportGenerator {

    public void generate(WiFiAnalyzer a) {

        System.out.println("========= REAL‑TIME WIFI ANALYSIS =========");

        if (a.isDisconnected) {
            System.out.println("❌ STATUS: DISCONNECTED");
            System.out.println("➡ Solution: Restart adapter / reconnect Wi-Fi");
            return;
        }

        System.out.println("SSID            : " + a.ssid);
        System.out.println("Signal Strength : " + a.signal + "%");
        System.out.println("Download Speed  : " + a.rxRate + " Mbps");
        System.out.println("Upload Speed    : " + a.txRate + " Mbps");

        System.out.println("\nDetected Issues & Possible Fixes:");

        if (a.signal < 40) {
            System.out.println("⚠ Weak Signal");
            System.out.println("➡ Move closer to router / remove obstacles\n");
        }

        if (a.rxRate < 20) {
            System.out.println("⚠ Slow Download Speed");
            System.out.println("➡ Reduce connected devices / change Wi-Fi channel\n");
        }

        if (a.signal >= 40 && a.rxRate >= 20) {
            System.out.println("✔ Wi-Fi is stable. No issues detected.\n");
        }
    }
}
