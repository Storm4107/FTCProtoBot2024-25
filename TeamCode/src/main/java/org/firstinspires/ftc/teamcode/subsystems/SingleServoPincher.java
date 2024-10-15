package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.robotcore.external.Telemetry;

public class SingleServoPincher {
    public Servo leftServo;
    public Servo rightServo;
    private GamepadEx Operator;


    public SingleServoPincher(HardwareMap Map, Telemetry telemetry) {
        leftServo = Map.get(Servo.class, "leftServo");
        rightServo = Map.get(Servo.class, "rightServo");
    }

    public void LeftServoPos(Servo leftServo){
        this.leftServo = leftServo;
    }

    public void RightServoPos(Servo rightServo){
        this.rightServo = rightServo;
    }

    public void setLeftServos(double leftValue) {
        leftServo.setPosition(leftValue);
    }

    public void setRightServos(double rightValue) {
        rightServo.setPosition(rightValue);
    }

    public double getLeftServoPosition(){
        return leftServo.getPosition();
    }

    public double getRightServoPosition(){
        return rightServo.getPosition();
    }

    public void ManualOpenRight(double input){
        setRightServos(0.5);
    }

    public void openRight(){
        setRightServos(0.5);
    }

    public void closeRight(){
        setRightServos(0.8);
    }

    public void openLeft(){
        setLeftServos(0.5);
    }

    public void closeLeft(){
        setLeftServos(0.8);
    }

    public void test(double open, double close, boolean LeftOpen, boolean LeftClose, boolean CounterClockWise, Boolean ClockWise) {
        if (LeftOpen)) {
            leftServo.setPosition(open);
        }
        //open pincher
        if ((LeftClose)) {
            leftServo.setPosition(close);
        }
        //rotate clockwise (looking from back of arm)
        if (ClockWise) {
            rightServo.setPosition(open);
        }
        //rotate counterclo,ckwise (looking from back of arm)
        if (CounterClockWise) {
           rightServo.setPosition(close);
        }
    }

}
