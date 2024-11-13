package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.hardware.ServoActuator;

public class PincherSubsystem {
    private ServoActuator pincher;
    private ServoActuator pivot;
    private ServoActuator leftWrist;
    private ServoActuator rightWrist;

    private Servo pincherServo;
    private Servo pivotServo;
    private Servo leftWristServo;
    private Servo rightWristServo;
    double pivotAngle = 0;

    public PincherSubsystem(HardwareMap Map) {
        //Servo hardwaremap setup
        pincherServo = Map.get(Servo.class, "pincherServo");
        pivotServo = Map.get(Servo.class, "pivotServo");
        leftWristServo = Map.get(Servo.class, "leftWristServo");
        rightWristServo = Map.get(Servo.class, "rightWristServo");

        //Hardware compilation
        pincher = new ServoActuator(pincherServo);
        pivot = new ServoActuator(pivotServo);
        leftWrist = new ServoActuator(leftWristServo);
        rightWrist = new ServoActuator(rightWristServo);
    }

    //set the angle of the pivot
    public void setPivotAngle(double angle) {
        pivot.setServos(angle);
    }

    public void setPivotAngleControl(double angle) {
        pivot.setServos(pivotServo.getPosition() + angle);
    }

    //set the angle of the wrist (Horizontal or Vertical)
    public void setWristAngle(double value) {
        leftWrist.setServos(value);
        rightWrist.setServos(1-value);
    }

    //set pincher to open
    public void open() {
        pincher.setServos(0.7);
    }

    //set pincher to closed
    public void close() {
        pincher.setServos(0);
    }

    //Presets
    public void groundPickup() {
        //open();
        setWristAngle(.8);
        setPivotAngle(0.45);
    }

    public void wallPickup() {
        // open();
        setWristAngle(.4);
        setPivotAngle(0.45);
    }

    public void retract() {
        setWristAngle(-1);
        setPivotAngle(0.6);
    }

    public void scoreSample() {
        setWristAngle(0.40);
        setPivotAngle(0.5);
    }

    public void scoreSpecimen() {
        setWristAngle(0);
        //  setPivotAngle(0);
    }


}