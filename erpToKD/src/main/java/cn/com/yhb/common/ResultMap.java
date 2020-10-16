package cn.com.yhb.common;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

/**
 * rest接口返回结果类
 * @author yhb
 *
 */

public class ResultMap extends HashMap<String, Object> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private HashMap<String, Object> header;

	private int code = HttpCodeEnum.OK.getCode();

	public ResultMap() {
	}

	public ResultMap success() {
		this.code = HttpCodeEnum.OK.getCode();
		this.header = new HashMap<>();
		this.header.put("code", this.code);
		this.header.put("msg", "Success");
		this.put("header", header);
		return this;
	}

	public ResultMap success(String token) {
		this.code = HttpCodeEnum.OK.getCode();
		this.header = new HashMap<>();
		this.header.put("code", this.code);
		this.header.put("msg", "Success");
		this.header.put("token", token);
		this.put("header", header);
		return this;
	}

	public ResultMap fail() {
		this.code = HttpCodeEnum.FAIL.getCode();
		this.header = new HashMap<>();
		this.header.put("code", code);
		this.put("header", header);
		return this;
	}

	public ResultMap fail(int code) {
		this.code = code;
		this.header = new HashMap<>();
		this.header.put("code", code);
		this.put("header", header);
		return this;
	}

	public ResultMap failWithToken(String token) {
		this.code = HttpCodeEnum.FAIL.getCode();
		this.header = new HashMap<>();
		this.header.put("code", code);
		this.header.put("msg", HttpCodeEnum.FAIL.getMessage());
		this.put("header", header);
		return this;
	}

	public ResultMap message(String message) {
		this.header.put("msg", message);
		this.put("header", header);
		return this;
	}

	public ResultMap data(Object object) {
		this.put("data", null == object ? Constants.EMPTY : object);
		return this;
	}

	public ResultMap datas(Collection list) {
		this.put("data", null == list ? new List[0] : list);
		return this;
	}

	public int getCode() {
		return code;
	}
}
