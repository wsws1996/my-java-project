package cn.wang.login2;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ImageServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("image/jpeg");
		response.setHeader("Expires", "-1");
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		BufferedImage image = new BufferedImage(100, 20,
				BufferedImage.TYPE_INT_RGB);
		Graphics2D graphics = (Graphics2D)image.getGraphics();
		graphics.setColor(Color.WHITE);
		graphics.fillRect(0, 0, 100, 20);
		graphics.setColor(Color.BLUE);
		graphics.setFont(new Font(null, Font.BOLD, 20));
		String checkcode=makeNum();
		request.getSession().setAttribute("checkcode", checkcode);
		graphics.drawString(checkcode, 0, 20);
		ImageIO.write(image, "jpg", response.getOutputStream());
	}

	private String makeNum() {
		// TODO Auto-generated method stub
		Random random = new Random();
		String num = random.nextInt(9999999) + "";
		StringBuffer stringBuffer = new StringBuffer();
		for (int i = 0; i < 7 - num.length(); i++) {
			stringBuffer.append(random.nextInt(9) + "");
		}
		num = stringBuffer.toString() + num;
		return num;
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
