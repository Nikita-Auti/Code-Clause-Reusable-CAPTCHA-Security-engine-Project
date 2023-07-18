package ReusableCaptchaSecurityEngineProject;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class ReusableCaptchaSecurityEngineProject {

    private static final int CAPTCHA_WIDTH = 200;
    private static final int CAPTCHA_HEIGHT = 80;
    private static final int CAPTCHA_LENGTH = 6;

    private static final String CAPTCHA_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    @SuppressWarnings("unused")
	public static void main(String[] args) {
        String captchaText = generateCaptchaText(CAPTCHA_LENGTH);
        BufferedImage captchaImage = generateCaptchaImage(captchaText);

        // Use the captchaText and captchaImage as needed (e.g., display on a web page, save to a file)
    }

    public static String generateCaptchaText(int length) {
        StringBuilder sb = new StringBuilder(length);
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(CAPTCHA_CHARACTERS.length());
            char randomChar = CAPTCHA_CHARACTERS.charAt(randomIndex);
            sb.append(randomChar);
        }

        return sb.toString();
    }

    public static BufferedImage generateCaptchaImage(String text) {
        BufferedImage image = new BufferedImage(CAPTCHA_WIDTH, CAPTCHA_HEIGHT, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = image.createGraphics();

        // Set background color
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, CAPTCHA_WIDTH, CAPTCHA_HEIGHT);

        // Set text color
        g2d.setColor(Color.BLACK);

        // Set font
        Font font = new Font("Arial", Font.BOLD, 40);
        g2d.setFont(font);

        // Draw text on the image
        FontMetrics fontMetrics = g2d.getFontMetrics();
        int textX = (CAPTCHA_WIDTH - fontMetrics.stringWidth(text)) / 2;
        int textY = (CAPTCHA_HEIGHT - fontMetrics.getHeight()) / 2 + fontMetrics.getAscent();
        g2d.drawString(text, textX, textY);

        // Add noise to the image (optional)

        g2d.dispose();
        return image;
    }
}
