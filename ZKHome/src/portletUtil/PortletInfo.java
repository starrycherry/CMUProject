package portletUtil;

/**
 * PortletInfo save resource of each portlet <br />
 * 1. urlMin : Widget default url <br />
 * 2. urlMax : Widget maximized url <br />
 * 3. type : use Iframe or Include <br />
 * 4. scroll : Weather the inner Iframe scrolling <br />
 * 4. minSize : Default height of widget
 * 
 * @author Ryan
 * 
 */
public class PortletInfo implements Comparable<PortletInfo> {
	private String urlMin;
	private String urlMax;
	private PortletType type;
	private String scroll;
	private String minSize;
	private String name;

	public PortletInfo(String name, String urlMin, String urlMax, PortletType type, String scroll, String minSize) {
		this.urlMin = urlMin;
		this.urlMax = urlMax;
		this.type = type;
		this.scroll = scroll;
		this.minSize = minSize;
		this.name = name;
	}

	public String getUrlMin() {
		return urlMin;
	}

	public String getUrlMax() {
		return urlMax;
	}

	public PortletType getType() {
		return type;
	}

	public String getScroll() {
		return scroll;
	}

	public String getMinSize() {
		return minSize;
	}

	public String getName() {
		return name;
	}

	public String toString() {
		return name;
	}
	
	public enum PortletType {
		IFRAME, INCLUDE;
	}

	@Override
	public int compareTo(PortletInfo o) {
		return this.name.compareTo(o.name);
	}
}
