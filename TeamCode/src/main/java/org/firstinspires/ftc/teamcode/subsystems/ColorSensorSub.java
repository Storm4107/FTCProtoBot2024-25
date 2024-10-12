package org.firstinspires.ftc.teamcode.subsystems;

import android.app.Activity;
import android.graphics.Color;
import android.view.View;

import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

import java.util.Locale;

    public class ColorSensorSub {
        public ColorSensor sensorColor;
        //public DistanceSensor sensorDistance;

        private Telemetry telemetry;


        public ColorSensorSub(HardwareMap Map, Telemetry telemetry) {

            this.telemetry = telemetry;
            sensorColor = Map.get(ColorSensor.class, "sensorColor");
           // sensorDistance = Map.get(DistanceSensor.class, "DistanceSensor");

            float hsvValues[] = {0F, 0F, 0F};

            // values is a reference to the hsvValues array.
            final float values[] = hsvValues;

            // sometimes it helps to multiply the raw RGB values with a scale factor
            // to amplify/attentuate the measured values.
            final double SCALE_FACTOR = 255;

            // get a reference to the RelativeLayout so we can change the background
            // color of the Robot Controller app to match the hue detected by the RGB sensor.
            int relativeLayoutId = Map.appContext.getResources().getIdentifier("RelativeLayout", "id", Map.appContext.getPackageName());
            final View relativeLayout = ((Activity) Map.appContext).findViewById(relativeLayoutId);
            Color.RGBToHSV((int)
                            (sensorColor.red() * SCALE_FACTOR),
                    (int) (sensorColor.green() * SCALE_FACTOR),
                    (int) (sensorColor.blue() * SCALE_FACTOR),
                    hsvValues);

            // send the info back to driver station using telemetry function.

            //telemetry.addData("Distance (cm)",
                    //String.format(Locale.US, "%.02f", sensorDistance.getDistance(DistanceUnit.CM)));
            telemetry.addData("Alpha", sensorColor.alpha());
            telemetry.addData("Red  ", sensorColor.red());
            telemetry.addData("Green", sensorColor.green());
            telemetry.addData("Blue ", sensorColor.blue());
            telemetry.addData("Hue", hsvValues[0]);
        }
                public void readColor() {
                    telemetry.addData("Alpha", sensorColor.alpha());
                    telemetry.addData("red", sensorColor.red());
                    telemetry.addData("green", sensorColor.green());
                    telemetry.addData("blue", sensorColor.blue());
                }

                // change the background color to match the color detected by the RGB sensor.
                // pass a reference to the hue, saturation, and value array as an argument
                // to the HSVToColor method.
            }




