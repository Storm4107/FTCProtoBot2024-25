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
    private DoubleMotorArm setpoint;
    private DoubleMotorArm D_arm;
    private ColorHuskylens m_COLORLens;



    private int objectPosition = 0;

    @Override
    public void runOpMode() {

        //Run when initializing
        m_Superstructure = new SuperstructureSubsystem(hardwareMap, telemetry);
        m_COLORLens = new ColorHuskylens(hardwareMap, telemetry);
        setpoint = new DoubleMotorArm(hardwareMap, telemetry);


        while (!isStopRequested() && !opModeIsActive()) {
            objectPosition = m_COLORLens.GetCenterstagePath();
            telemetry.addData("Position during Init", objectPosition);
            telemetry.update();
        }
        waitForStart();

        if (isStopRequested()) return;
        
        telemetry.addData("Angle",setpoint);


        }

    }
}
