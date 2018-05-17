package com.vulnverify.core.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ip验证工具类
 * @author linan
 *
 */
public class IpUtil {

	/*
	 * 验证IP是否属于某个IP段
	 * ipSection IP段（以'-'分隔）
	 * ip 所验证的IP号码
	 */

	public static boolean ipExistsInRange(String ip, String ipSection) {

		ipSection = ipSection.trim();

		ip = ip.trim();

		int idx = ipSection.indexOf('-');

		String beginIP = ipSection.substring(0, idx);

		String endIP = ipSection.substring(idx + 1);

		return getIp2long(beginIP) <= getIp2long(ip)
				&& getIp2long(ip) <= getIp2long(endIP);

	}

	public static long getIp2long(String ip) {

		ip = ip.trim();

		String[] ips = ip.split("\\.");

		long ip2long = 0L;

		for (int i = 0; i < 4; ++i) {

			ip2long = ip2long << 8 | Integer.parseInt(ips[i]);

		}

		return ip2long;

	}

	public static long getIp2long2(String ip) {

		ip = ip.trim();

		String[] ips = ip.split("\\.");

		long ip1 = Integer.parseInt(ips[0]);

		long ip2 = Integer.parseInt(ips[1]);

		long ip3 = Integer.parseInt(ips[2]);

		long ip4 = Integer.parseInt(ips[3]);

		long ip2long = 1L * ip1 * 256 * 256 * 256 + ip2 * 256 * 256 + ip3 * 256
				+ ip4;

		return ip2long;

	}

	/**
	 * 正则校验ip
	 * 
	 * @param ipAddress
	 * @return
	 */
	public static boolean isIpv4(String ipAddress) {

		String ip = "^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\."
					+ "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."
					+ "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."
					+ "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$";
		Pattern pattern = Pattern.compile(ip);
		Matcher matcher = pattern.matcher(ipAddress);
		return matcher.matches();

	}

	
	public static void main(String[] args) {
		// 10.10.10.116 是否属于固定格式的IP段10.10.1.00-10.10.255.255
		 String ipRange1="10.10.10.116-20.10.10.280";
		  
		 String ipRange2="10.10.1.00-10.10.255.255,10.10.1.00-10.10.255.255";
		 boolean ipRangeByIpRange = isIpRangeByIpRange(ipRange1, ipRange2);
		 System.out.println(ipRangeByIpRange);
		 
		 
	}
	/**
	 * 判断一个ip范围是否在另一个ip范围内
	 * @param scanIpRange1 小的ip范围
	 * @param scanIpRange2 大的ip范围
	 * @return
	 */
	public static boolean isIpRangeByIpRange(String scanIpRange1,String scanIpRange2) {
		/**
		 * scanIpRange1和scanIpRange2的范围格式有3种情况
		 * 192.168.1.1   一个ip
		 * 192.168.1.1-192.168.1.2   范围以“-”连接
		 * 192.168.1.1-192.168.1.2,192.168.1.3-192.168.1.4  多个范围以“,”分隔
		 */
		boolean temp=false;
		String small = scanIpRange1.trim();
		String big = scanIpRange2.trim();
		String[] smalls = small.split(",");
		String[] bigs = big.split(",");
		for (String smallIp : smalls) {
			
			String[] smallIps = smallIp.split("-");
			String smallStartIp =null;
			String smallEndIp =null;
			if(smallIps.length<1){
				 smallStartIp = smallIps[0];
				 smallEndIp = smallIps[1];
			}else{
				 smallStartIp = smallIps[0];
			}
			for (String bigIpRange : bigs) {
				boolean ipStartExistsInRange = ipExistsInRange(smallStartIp,bigIpRange);
				boolean ipEndExistsInRange = false;
				if(null!=smallEndIp){
				 ipEndExistsInRange = ipExistsInRange(smallEndIp,bigIpRange);
				}else{
					ipEndExistsInRange=true;
				}
				//开头和结尾都在范围内
				temp=ipStartExistsInRange & ipEndExistsInRange;
				if(!temp){
					return temp;
				}
			}
		}
		return temp;
	}
	/**
	 * 验证ip范围正则
	 * @param scanIprangeString
	 * @return false 验证失败 true 验证通过
	 */
	public static boolean isIpv4ByIpRange(String scanIprangeString) {
		String trim = scanIprangeString.trim();
		int idx = scanIprangeString.indexOf('-');
		String beginIP = scanIprangeString.substring(0, idx);

		String endIP = scanIprangeString.substring(idx + 1);
		
		//校验数据数据是否是ip
		boolean beginIpIsIpv4 = IpUtil.isIpv4(beginIP);
		if(!beginIpIsIpv4){
			return false;
		}
		boolean endIpIsIpv4 = IpUtil.isIpv4(endIP);
		if(!endIpIsIpv4){
			return false;
		}
		return true;
	}

}