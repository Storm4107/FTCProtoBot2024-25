package org.firstinspires.ftc.teamcode.auto;

import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.MecanumDrive;
import org.firstinspires.ftc.teamcode.subsystems.ColorSensorSub;
import org.firstinspires.ftc.teamcode.subsystems.ColorHuskylens;
import org.firstinspires.ftc.teamcode.subsystems.DoubleMotorArm;
import org.firstinspires.ftc.teamcode.subsystems.SuperstructureSubsystem;

@Config
@Autonomous(name = "ExampleColorSensor", group = "Autonomous")
public class ExampleColorSensor extends LinearOpMode {
    //Instantiate mechanisms

    public ColorSensorSub m_ColorSensor;




    @Override
    public void runOpMode() {

        //Run when initializing
        m_ColorSensor = new ColorSensorSub(hardwareMap, telemetry);


        while (!isStopRequested() && !opModeIsActive()) {
            telemetry.addData("Color",m_ColorSensor.hashCode() );

        }
        waitForStart();

        if (isStopRequested()) return;
        //use this to get your angles
        while (opModeIsActive()) {
            m_ColorSensor.readColor();
            telemetry.update();
        }


        //once you get your angels use the code below to move it. This is moving by manual count input, if this is a reoccurring angle make a preset function in SuperstructureSubsystem
        //m_Superstructure.Arm.setAngle(2);

        //example of how you would call a preset
        //m_Superstructure.zeroPreset();
    }

}

