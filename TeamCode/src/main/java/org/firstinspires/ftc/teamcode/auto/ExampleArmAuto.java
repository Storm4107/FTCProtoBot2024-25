package org.firstinspires.ftc.teamcode.auto;

import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.MecanumDrive;
import org.firstinspires.ftc.teamcode.subsystems.ColorHuskylens;
import org.firstinspires.ftc.teamcode.subsystems.DoubleMotorArm;
import org.firstinspires.ftc.teamcode.subsystems.MecanumDriveSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.SuperstructureSubsystem;

@Config
@Autonomous(name = "ARMAutoEXAMPLE", group = "Autonomous")
public class ExampleArmAuto extends LinearOpMode {
    //Instantiate mechanisms
    public SuperstructureSubsystem m_Superstructure;
    private ColorHuskylens m_COLORLens;
    private DoubleMotorArm m_DoubleMotorArm;



    private int objectPosition = 0;

    @Override
    public void runOpMode() {

        //Run when initializing
        m_Superstructure = new SuperstructureSubsystem(hardwareMap, telemetry);
        m_COLORLens = new ColorHuskylens(hardwareMap, telemetry);


        while (!isStopRequested() && !opModeIsActive()) {
            telemetry.addData("ANGLE",m_DoubleMotorArm.getAngle() );

        }
        waitForStart();

        if (isStopRequested()) return;
        //use this to get your angles
        m_Superstructure.Arm.setOutput(gamepad1.left_stick_y);
        telemetry.addData("ANGLE",m_DoubleMotorArm.getAngle() );

        //once you get your angels use the code below to move it. This is moving by manual count input, if this is a reoccurring angle make a preset function in SuperstructureSubsystem
        //m_Superstructure.Arm.setAngle(2);

        //example of how you would call a preset
        //m_Superstructure.zeroPreset();
        }

    }

