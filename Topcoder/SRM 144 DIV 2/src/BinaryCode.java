public class BinaryCode {
	private int getValue(int[] p, int i) {
		if (i < 0 || i >= p.length) return 0;
		return p[i];
	}

	private String decode(int setByte, String message) {
		int[] p = new int[message.length()];
		p[0] = setByte;
		char[] chars = message.toCharArray();
		StringBuilder sb = new StringBuilder();
		sb.append(p[0]);
		for (int i = 0; i < chars.length - 1; i++) {
			int _qi = (chars[i] - '0');
			p[i + 1] = _qi - getValue(p, i - 1) - getValue(p, i);
			if (getValue(p, i + 1) < 0 || getValue(p, i + 1) > 1) {
				return "NONE";
			}
			sb.append(p[i + 1]);
		}

		if ((chars[chars.length - 1] - '0') != getValue(p, p.length - 1) + getValue(p, p.length - 2)) {
			return "NONE";
		} else {
			return sb.toString();
		}

	}

	//123210120
	public String[] decode(String messsage) {
		return new String[]{decode(0, messsage), decode(1, messsage)};
	}
}
