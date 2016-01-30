package cn.wang.web.filter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.wang.web.Wrappers.BufferResponse;

public class GzipFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;

		BufferResponse bufferResponse = new BufferResponse(response);

		chain.doFilter(request, bufferResponse);

		byte out[] = bufferResponse.getBuffer();
		System.out.println("原始大小："+out.length);

		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

		GZIPOutputStream gzipOutputStream = new GZIPOutputStream(
				byteArrayOutputStream);
		gzipOutputStream.write(out);
		gzipOutputStream.close();

		byte gzip[] = byteArrayOutputStream.toByteArray();
		System.out.println("压缩后大小："+gzip.length);
		response.setHeader("content-encoding", "gzip");
		response.setContentLength(gzip.length);
		response.getOutputStream().write(gzip);

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
