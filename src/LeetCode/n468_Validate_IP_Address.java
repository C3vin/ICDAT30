package LeetCode;

/*
Given a string IP, return "IPv4" if IP is a valid IPv4 address, "IPv6" if IP is a valid IPv6 address or "Neither" if IP is not a correct IP of any type.

A valid IPv4 address is an IP in the form "x1.x2.x3.x4" where 0 <= xi <= 255 and xi cannot contain leading zeros. For example, "192.168.1.1" and "192.168.1.0" are valid IPv4 addresses but "192.168.01.1", while "192.168.1.00" and "192.168@1.1" are invalid IPv4 addresses.

A valid IPv6 address is an IP in the form "x1:x2:x3:x4:x5:x6:x7:x8" where:

1 <= xi.length <= 4
xi is a hexadecimal string which may contain digits, lower-case English letter ('a' to 'f') and upper-case English letters ('A' to 'F').
Leading zeros are allowed in xi.
For example, "2001:0db8:85a3:0000:0000:8a2e:0370:7334" and "2001:db8:85a3:0:0:8A2E:0370:7334" are valid IPv6 addresses, while "2001:0db8:85a3::8A2E:037j:7334" and "02001:0db8:85a3:0000:0000:8a2e:0370:7334" are invalid IPv6 addresses.
Example 1:

Input: IP = "172.16.254.1"
Output: "IPv4"
Explanation: This is a valid IPv4 address, return "IPv4".
Example 2:

Input: IP = "2001:0db8:85a3:0:0:8A2E:0370:7334"
Output: "IPv6"
Explanation: This is a valid IPv6 address, return "IPv6".
Example 3:

Input: IP = "256.256.256.256"
Output: "Neither"
Explanation: This is neither a IPv4 address nor a IPv6 address.
Example 4:

Input: IP = "2001:0db8:85a3:0:0:8A2E:0370:7334:"
Output: "Neither"
Example 5:

Input: IP = "1e1.4.5.6"
Output: "Neither"


Constraints:

IP consists only of English letters, digits and the characters '.' and ':'.
 */
public class n468_Validate_IP_Address {
	public String validIPAddress(String IP) {
		if(IP.length()==0) return "Neither";

		if(IP.indexOf(".")>=0) return validateIPV4(IP);

		if(IP.indexOf(":")>=0) return validateIPV6(IP);

		return "Neither";
	}

	private  String validateIPV4(String ip){
		// step 1 
		if(ip.charAt(0)=='.' || ip.charAt(ip.length()-1)=='.') return "Neither";

		//step 2 
		String[] component=ip.split("\\.");

		//step 3
		if(component.length!=4) return "Neither";

		//step 4
		for(String comp:component){
			if(comp.length()==0 || comp.length()>3 || (comp.charAt(0)=='0' && comp.length()>1)){
				return "Neither";
			}

			//step5
			for(char ch:comp.toCharArray()){
				if(ch<'0' || ch>'9') return "Neither";
			}

			//step6
			int num=Integer.parseInt(comp);
			if(num<0 || num>255) return "Neither";

		}

		return "IPv4";
	}

	private String validateIPV6(String ip){
		if(ip.charAt(0)==':' || ip.charAt(ip.length()-1)==':') return "Neither";

		String[] component=ip.split(":");

		if(component.length!=8) return "Neither";

		for(String comp:component){
			if(comp.length()==0 || comp.length()>4) return "Neither";


			for(char ch:comp.toLowerCase().toCharArray()){
				if((ch<'0' || ch>'9') && (ch!='a' && ch!='b' && ch!='c' && ch!='d' && ch!='e' && ch!='f')){
					return "Neither";
				}  
			}
		}
		return "IPv6";
	}

	public static void main(String[] args) {
		n468_Validate_IP_Address obj = new n468_Validate_IP_Address();
		System.out.println(obj.validIPAddress("172.16.254.1"));
		System.out.println(obj.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334"));
		System.out.println(obj.validIPAddress("256.256.256.256"));
		System.out.println(obj.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334:"));
	}
}
