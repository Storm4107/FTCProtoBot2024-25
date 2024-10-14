package org.firstinspires.ftc.teamcode.teleop;

import com.arcrobotics.ftclib.command.button.GamepadButton;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.robotcore.external.Telemetry;

import org.firstinspires.ftc.teamcode.subsystems.ApriltagHuskylens;
import org.firstinspires.ftc.teamcode.subsystems.ApriltagUSBCamera;
import org.firstinspires.ftc.teamcode.subsystems.ColorHuskylens;
import org.firstinspires.ftc.teamcode.subsystems.MecanumDriveSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.SingleServoPincher;
import org.firstinspires.ftc.teamcode.subsystems.SuperstructureSubsystem;

@TeleOp(name = "Example Teleop")
public class ExampleTeleop extends LinearOpMode {

    //Gamepad bindings
    private GamepadEx Driver;
    private GamepadEx Operator;

    private GamepadButton imuReset;

    //subsystems
    private MecanumDriveSubsystem m_Drive;
    private SuperstructureSubsystem m_Superstructure;
    private SingleServoPincher m_SingleServoPincher;
    private ApriltagHuskylens m_ATLens;
    private ColorHuskylens m_COLORLens;
    private ApriltagUSBCamera m_ATUSB;


   // @Override
    public void runOpMode() {
        //Run when initializing
        m_Drive = new MecanumDriveSubsystem(hardwareMap, telemetry);
        m_Superstructure = new SuperstructureSubsystem(hardwareMap, telemetry);
        m_ATLens = new ApriltagHuskylens(hardwareMap, telemetry);
        m_COLORLens = new ColorHuskylens(hardwareMap, telemetry);
        m_ATUSB = new ApriltagUSBCamera(hardwareMap, telemetry);
        m_SingleServoPincher = new SingleServoPincher(hardwareMap,telemetry);
        Driver = new GamepadEx(gamepad1);
        Operator = new GamepadEx(gamepad2);

        telemetry.update();
        waitForStart();
        //Run immediately when starting


        while (opModeIsActive()) {
                //Periodic Opmode
                m_Superstructure.periodic();
                m_ATLens.runHuskyLens();
                m_COLORLens.runHuskyLens();
                m_ATUSB.periodic();

                telemetry.addData(
                        "Periodic currently running",
                        "Operator can hold left bumper for manual arm control");


                //IMU Reset button
                if (Driver.getButton(GamepadKeys.Button.Y)) {
                   m_Drive.resetHeading();
                }

                //Drivetrain method
                m_Drive.Drive(Driver.getLeftX(), Driver.getLeftY(), Driver.getRightX(), Driver.getButton(GamepadKeys.Button.RIGHT_BUMPER));

                //Superstructure preset - Zero everything
                if (Operator.getButton(GamepadKeys.Button.BACK)) {
                    m_Superstructure.zeroPreset();
                }

                if (Operator.getButton(GamepadKeys.Button.A)) {
                    m_Superstructure.pickupPreset();
                }

                if (Operator.getButton(GamepadKeys.Button.X)) {
                    m_Superstructure.mediumPreset();
                }

                if (Operator.getButton(GamepadKeys.Button.Y)) {
                    m_Superstructure.highPreset();
                }

                //Superstructure manual input toggle - Triggered by holding holding left bumper
                if (Operator.getButton(GamepadKeys.Button.DPAD_UP)) {
                    m_Superstructure.ManualInput(
                            Operator.getLeftY(),
                            Operator.getButton(GamepadKeys.Button.A),
                            Operator.getButton(GamepadKeys.Button.B),
                            Operator.getButton(GamepadKeys.Button.X)
                    );
                    telemetry.addData(
                            "MANUAL INPUT ENABLED",
                            "A = ARM, B = WRIST, X = ELEVATOR." + "USE LEFT STICK TO CONTROL INPUT");

                }

                //double Pincher controls
                /*
                if (Operator.getButton(GamepadKeys.Button.LEFT_BUMPER)) {
                    m_Superstructure.Pincher.open();
                    SingleServoPincher.leftServo.setPosition(.5);
                }

                //
                if ((Operator.getTrigger(GamepadKeys.Trigger.LEFT_TRIGGER) > 0.3)) {
                    m_Superstructure.Pincher.close();
                    SingleServoPincher.leftServo.setPosition(.8);
                }
                */
            
                //single pincher controls
                //close pincher
                if (Operator.getButton(GamepadKeys.Button.LEFT_BUMPER)) {
                    m_SingleServoPincher.leftServo.setPosition(.5);
                }
                //open pincher
                if ((Operator.getTrigger(GamepadKeys.Trigger.LEFT_TRIGGER) > 0.3)) {
                    m_SingleServoPincher.leftServo.setPosition(.8);
                }
                //rotate clockwise (looking from back of arm)
                 if (Operator.getButton(GamepadKeys.Button.RIGHT_BUMPER)) {
                     m_SingleServoPincher.rightServo.setPosition(.5);
                }
                //rotate counterclockwise (looking from back of arm)
                 if ((Operator.getTrigger(GamepadKeys.Trigger.RIGHT_TRIGGER) > 0.3)) {
                     m_SingleServoPincher.rightServo.setPosition(.8);
                }
            telemetry.addData(
                    "left servo", m_SingleServoPincher.leftServo.getPosition());
            telemetry.addData(
                    "right servo", m_SingleServoPincher.rightServo.getPosition());
                telemetry.update();
            }
        }
    }

