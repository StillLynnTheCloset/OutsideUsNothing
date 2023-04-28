package com.stilllynnthecloset.hexgridcompose

import java.awt.BasicStroke
import java.awt.Color
import java.awt.Graphics2D
import java.awt.Point
import java.awt.Polygon

public class Hexagon constructor(center: Point, radius: Int) : Polygon() {
    private val points = arrayOfNulls<Point>(SIDES)
    private var center = Point(0, 0)
    private var radius: Int
    private var rotation = 90

    init {
        npoints = SIDES
        xpoints = IntArray(SIDES)
        ypoints = IntArray(SIDES)
        this.center = center
        this.radius = radius
        updatePoints()
    }

    public constructor(x: Int, y: Int, radius: Int) : this(Point(x, y), radius) {}

    public fun getRadius(): Int {
        return radius
    }

    public fun setRadius(radius: Int) {
        this.radius = radius
        updatePoints()
    }

    public fun getRotation(): Int {
        return rotation
    }

    public fun setRotation(rotation: Int) {
        this.rotation = rotation
        updatePoints()
    }

    public fun setCenter(center: Point) {
        this.center = center
        updatePoints()
    }

    public fun setCenter(x: Int, y: Int) {
        setCenter(Point(x, y))
    }

    private fun findAngle(fraction: Double): Double {
        return fraction * Math.PI * 2 + Math.toRadians(((rotation + 180) % 360).toDouble())
    }

    private fun findPoint(angle: Double): Point {
        val x = (center.x + Math.cos(angle) * radius).toInt()
        val y = (center.y + Math.sin(angle) * radius).toInt()
        return Point(x, y)
    }

    protected fun updatePoints() {
        for (p in 0 until SIDES) {
            val angle = findAngle(p.toDouble() / SIDES)
            val point = findPoint(angle)
            xpoints[p] = point.x
            ypoints[p] = point.y
            points[p] = point
        }
    }

    public fun draw(g: Graphics2D, x: Int, y: Int, lineThickness: Int, colorValue: Int, filled: Boolean) {
        // Store before changing.
        val tmpS = g.stroke
        val tmpC = g.color
        g.color = Color(colorValue)
        g.stroke = BasicStroke(lineThickness.toFloat(), BasicStroke.CAP_SQUARE, BasicStroke.JOIN_MITER)
        if (filled) g.fillPolygon(xpoints, ypoints, npoints) else g.drawPolygon(xpoints, ypoints, npoints)

        // Set values to previous when done.
        g.color = tmpC
        g.stroke = tmpS
    }

    public companion object {
        private const val serialVersionUID = 1L
        public const val SIDES: Int = 6
    }
}