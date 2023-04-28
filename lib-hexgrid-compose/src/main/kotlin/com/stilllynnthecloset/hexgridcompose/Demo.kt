package com.stilllynnthecloset.hexgridcompose

import java.awt.BasicStroke
import java.awt.Color
import java.awt.Dimension
import java.awt.Font
import java.awt.FontMetrics
import java.awt.Graphics
import java.awt.Graphics2D
import java.awt.Point
import javax.swing.JFrame
import javax.swing.JPanel


public class HexJPanel : JPanel() {
    private val WIDTH = 1200
    private val HEIGHT = 800
    private val font = Font("Arial", Font.BOLD, 18)
    private var metrics: FontMetrics? = null

    init {
        preferredSize = Dimension(WIDTH, HEIGHT)
    }

    public override fun paintComponent(g: Graphics) {
        val g2d = g as Graphics2D
        val origin = Point(size.width / 2, size.height / 2)
        g2d.stroke = BasicStroke(4.0f, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_MITER)
        g2d.font = font
        metrics = g.getFontMetrics()
        drawHexGridLoop(g2d, origin, 7, 50, 50)
    }

    public fun drawHexGridLoop(g: Graphics, origin: Point, size: Int, radius: Int, padding: Int) {
        val ang30 = Math.toRadians(30.0)
        val xOff = Math.cos(ang30) * (radius + padding)
        val yOff = Math.sin(ang30) * (radius + padding)
        val half = size / 2
        for (row in 0 until size) {
            val cols = size - Math.abs(row - half)
            for (col in 0 until cols) {
                val xLbl = if (row < half) col - row else col - half
                val yLbl = row - half
                val x = (origin.x + xOff * (col * 2 + 1 - cols)).toInt()
                val y = (origin.y + yOff * (row - half) * 3).toInt()
                drawHex(g, xLbl, yLbl, x, y, radius)
            }
        }
    }

    public fun drawHex(g: Graphics, posX: Int, posY: Int, x: Int, y: Int, r: Int) {
        val g2d = g as Graphics2D
        val hex = Hexagon(x, y, r)
        val text = String.format("%s : %s", coord(posX), coord(posY))
        val w = metrics!!.stringWidth(text)
        val h = metrics!!.height
        hex.draw(g2d, x, y, 0, 0x008844, true)
        hex.draw(g2d, x, y, 4, 0xFFDD88, false)
        g.setColor(Color(0xFFFFFF))
        g.drawString(text, x - w / 2, y + h / 2)
    }

    public fun coord(value: Int): String {
        return (if (value > 0) "+" else "") + value.toString()
    }
}

public fun main() {
    val p = HexJPanel()
    JFrame().apply {
        contentPane = p
        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        pack()
        setLocationRelativeTo(null)
        isVisible = true
    }
}