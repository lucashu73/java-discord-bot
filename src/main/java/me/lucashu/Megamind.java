package me.lucashu;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.concurrent.TimeUnit;

public class Megamind extends ListenerAdapter {

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        String[] LIST_OF_ENDINGS = {",", ".", "!", "?"};
        File meme = new File("src/main/java/megamind/images/meme.png");
        String[] message = event.getMessage().getContentRaw().split(" ");

        if(!event.getAuthor().isBot()) {
            for (int n = 0; n < message.length; n++) {
                if (message[n].equalsIgnoreCase("no")) {
                    String reply = "";

                    for (int i = n; i < message.length; i++) {
                        if (message[i].contains(",") || message[i].contains(".")
                                || message[i].contains("!") || message[i].contains("?")) {
                            reply = reply.concat(" " + message[i].replaceAll("[^A-Za-z]+", ""));
                            break;
                        } if (message[i].equalsIgnoreCase("no") && reply != "") {
                            break;
                        }
                        reply = reply.concat(" " + message[i]);
                    }

                    try {
                        System.out.println(reply);
                        makeMeme(reply + "?");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    event.getMessage().reply(meme).mentionRepliedUser(false).queue();

                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void makeMeme(String s) throws Exception{
        Font font = new Font("Impact", Font.PLAIN, 48);
        File file = new File("src/main/java/megamind/images/megamind.png");
        BufferedImage image = ImageIO.read(file);

        Graphics g = image.getGraphics();
        Graphics2D g2d = (Graphics2D)g;
        FontMetrics metrics = g2d.getFontMetrics(font);
        int positionX;
        int positionY = image.getHeight() / 8;
        int lineHeight = metrics.getHeight();

        g2d.setFont(font);
        g2d.setColor(Color.WHITE);

        String[] words = s.split(" ");
        String temp = "";

        for (String word : words) {
            int wordWidth = metrics.stringWidth(word);
            int tempWidth = metrics.stringWidth(temp);

            if (tempWidth + wordWidth >= image.getWidth()) {
                positionX = (image.getWidth() - tempWidth) / 2 + 14;
                drawOutlinedText(g, temp, positionX, positionY);
                //g2d.drawString(temp, positionX, positionY);
                positionY += lineHeight;
                temp = word;
            } else {
                if (temp == "") {
                    temp = temp.concat(word);
                } else {
                    temp = temp.concat(" " + word);
                }
            }

        }

        positionX = (image.getWidth() - metrics.stringWidth(temp)) / 2 + 14;
        drawOutlinedText(g, temp, positionX, positionY);
        //g2d.drawString(temp, positionX, positionY);
        g2d.dispose();
        ImageIO.write(image, "png", new File("src/main/java/megamind/images/meme.png"));
    }


    public void drawOutlinedText(Graphics g, String text, int x, int y) {
        Graphics2D g2d = (Graphics2D)g;
        AffineTransform transform = g2d.getTransform();
        transform.translate(x, y);
        g2d.transform(transform);
        g2d.setColor(Color.black);
        FontRenderContext frc = g2d.getFontRenderContext();
        TextLayout tl = new TextLayout(text, g.getFont().deriveFont(45F), frc);
        Shape shape = tl.getOutline(null);
        g2d.setStroke(new BasicStroke(5f));
        g2d.draw(shape);
        g2d.setColor(Color.white);
        g2d.fill(shape);
        g2d.translate(-x, -y);
    }

}
