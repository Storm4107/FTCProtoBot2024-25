package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.robotcore.external.Telemetry;

public class SingleServoPincher {
    public Servo leftServo;
    public Servo rightServo;



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
}
