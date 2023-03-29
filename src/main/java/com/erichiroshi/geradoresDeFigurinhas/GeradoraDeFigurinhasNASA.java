package com.erichiroshi.geradoresDeFigurinhas;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import java.net.URL;

import javax.imageio.ImageIO;

import com.erichiroshi.entities.Conteudo;
import com.erichiroshi.entities.ConteudoNASA;

public class GeradoraDeFigurinhasNASA implements GeradoraDeFigurinhas{

    public void cria(Conteudo conteudo) {
        try {
            ConteudoNASA conteudoNASA = (ConteudoNASA) conteudo;
            InputStream inputStream = new URL(conteudoNASA.url()).openStream();
            BufferedImage imagemOriginal = ImageIO.read(inputStream);

            String textoFigurinha = "TOPZERA";

            int largura = imagemOriginal.getWidth();
            int altura = imagemOriginal.getHeight();
            int novaAltura = altura + 200;
            BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

            Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
            graphics.drawImage(imagemOriginal, 0, 0, null);

            Font fonte = new Font("Comic Sans MS", Font.BOLD, 100);
            graphics.setFont(fonte);
            graphics.setColor(Color.YELLOW);

            FontMetrics fontMetrics = graphics.getFontMetrics();
            Rectangle2D retangulo = fontMetrics.getStringBounds(textoFigurinha, graphics);
            int larguraTexto = (int) retangulo.getWidth();
            int posicaoTextoX = (largura - larguraTexto) / 2;
            int posicaoTextoY = novaAltura - 70;
            graphics.drawString(textoFigurinha, posicaoTextoX, posicaoTextoY);

            FontRenderContext fontRenderContext = graphics.getFontRenderContext();
            TextLayout textLayout = new TextLayout(textoFigurinha, fonte, fontRenderContext);

            Shape outline = textLayout.getOutline(null);
            AffineTransform transform = graphics.getTransform();
            transform.translate(posicaoTextoX, posicaoTextoY);
            graphics.setTransform(transform);

            BasicStroke basicStroke = new BasicStroke(largura * 0.004f);
            graphics.setStroke(basicStroke);

            graphics.setColor(Color.BLACK);
            graphics.draw(outline);
            graphics.setClip(outline);

            File diretorio = new File("src/main/resources/saida");
            diretorio.mkdir();
            String nomeArquivo = conteudoNASA.title() + ".png";

            nomeArquivo = nomeArquivo.replace(":", " -");

            ImageIO.write(novaImagem, "png", new File(diretorio + "/" + nomeArquivo));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}