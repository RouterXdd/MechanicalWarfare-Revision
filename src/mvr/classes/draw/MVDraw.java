package mvr.classes.draw;

import arc.func.Floatc2;
import arc.graphics.Color;
import arc.graphics.g2d.*;
import arc.math.Angles;
import arc.math.Mathf;

//Moved to java MV's effect shortcuts
public class MVDraw {
    public static void outlineCircle(float x, float y, Color col, float thickness, float radius){
        Draw.color(col);
        Lines.stroke(thickness);
        Lines.circle(x, y, radius);
        Draw.color();
        Lines.stroke(1);
    }
    public static void outlineCircleWCol(float x, float y, float thickness, float radius){
        Lines.stroke(thickness);
        Lines.circle(x, y, radius);
        Lines.stroke(1);
    }
    public static void fillCircle(float x, float y, Color col, float alpha, float radius){
        Draw.color(col);
        Draw.alpha(alpha);
        Fill.circle(x, y, radius);
        Draw.color();
    }
    public static void fillCircleWCol(float x, float y, float radius){
        Fill.circle(x, y, radius);
    }
    public static void fillPolygon(float x, float y, Color col, float alpha, int sides, float size, float rot){
        Draw.color(col);
        Draw.alpha(alpha);
        Fill.poly(x, y, sides, size, rot);
        Draw.color();
    }
    public static void fillPolygonWCol(float x, float y, int sides, float size, float rot){
        Fill.poly(x, y, sides, size, rot);
    }
    public static void splashLines(float x, float y, Color col, float thickness, float distance, float length, int count, long seed){
        Draw.color(col);
        Lines.stroke(thickness);
        Angles.randLenVectors(seed, count, distance, (a, b) -> {
            Lines.lineAngle(x + a, y + b, Mathf.angle(a, b), length);
        });
        Draw.color();
        Lines.stroke(1);
    }
    public static void splashLinesWCol(float x, float y, float thickness, float distance, float length, int count, long seed){
        Lines.stroke(thickness);
        Angles.randLenVectors(seed, count, distance, (a, b) -> {
            Lines.lineAngle(x + a, y + b, Mathf.angle(a, b), length);
        });
        Lines.stroke(1);
    }
    public static void splashCircles(float x, float y, Color col, float alpha, float radius, float distance, int count, long seed){
        Angles.randLenVectors(seed, count, distance, (a, b) -> {
            fillCircle(x + a, y + b, col, alpha, radius);
        });
    }
    public static void splashCirclesWCol(float x, float y, float radius, float distance, int count, long seed){
        Angles.randLenVectors(seed, count, distance, (a, b) -> {
            fillCircleWCol(x + a, y + b, radius);
        });
    }
}
