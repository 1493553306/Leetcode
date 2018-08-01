package Base;

public class StringToIpv4 {
    private final long PART1 = 0xff000000;
    private final long PART2 = 0xff0000;
    private final long PART3 = 0xff00;
    private final long PART4 = 0xff;

    /** 将IP地址长整型数值转化为IPv4字符串 */
    public String ip2Str(long ip) {
        String ipStr = String.valueOf((ip & PART1) >> 24);
        ipStr += "." + ((ip & PART2) >> 16);
        ipStr += "." + ((ip & PART3) >> 8);
        ipStr += "." + (ip & PART4);
        System.out.print(ipStr);
        return ipStr;
    }

    public static void main(String[] args){
        String ip = "192.168.1.10";
            String[] p4 = ip.split("\\.");
            long ipInt = 0;
            long part = Long.valueOf(p4[0]);
            ipInt = ipInt | (part << 24);
            part = Long.valueOf(p4[1]);
            ipInt = ipInt | (part << 16);
            part = Long.valueOf(p4[2]);
            ipInt = ipInt | (part << 8);
            part = Long.valueOf(p4[3]);
            ipInt = ipInt | (part);
            System.out.println(ipInt);
            StringToIpv4 sl = new StringToIpv4();
            sl.ip2Str(ipInt);

        }
}
