package org.firstinspires.ftc.teamcode.teleop;

import com.arcrobotics.ftclib.command.button.GamepadButton;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.subsystems.MecanumDriveSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.SuperstructureSubsystem;

@TeleOp(name = "Drive Train Base")
public class DriveTrainBase extends LinearOpMode {

    //Gamepad bindings
    private GamepadEx Driver;
    private GamepadEx Operator;

    private GamepadButton imuReset;


    //subsystems
    private MecanumDriveSubsystem m_Drive;
    private SuperstructureSubsystem m_Superstructure;



    @Override
    public void runOpMode() {
        //Run when initializing
        m_Drive = new MecanumDriveSubsystem(hardwareMap, telemetry);
        m_Superstructure = new SuperstructureSubsystem(hardwareMap, telemetry);

        Driver = new GamepadEx(gamepad1);
        Operator = new GamepadEx(gamepad2);

        telemetry.update();
        waitForStart();
        //Run immediately when starting


        while (opModeIsActive()) {
                //Periodic Opmode
                telemetry.addData(
                        "Periodic currently running",
                        "Operator can hold left bumper for manual arm control");


                //IMU Reset button
                if (Driver.getButton(GamepadKeys.Button.Y)) {
                   m_Drive.resetHeading();
                }

                //Drivetrain method
                m_Drive.Drive(Driver.getLeftX(), Driver.getLeftY(), Driver.getRightX(), Driver.getButton(GamepadKeys.Button.RIGHT_BUMPER));


                //Superstructure manual input toggle - Triggered by holding holding left bumper
            //Superstructure preset - Zero everything
            if (Operator.getButton(GamepadKeys.Button.START)) {
                m_Superstructure.zeroPreset();
            }

            if (Operator.getButton(GamepadKeys.Button.A)) {
                m_Superstructure.groundPickupPreset();
            }

            if (Operator.getButton(GamepadKeys.Button.X)) {
                m_Superstructure.lowPreset();
            }

            if (Operator.getButton(GamepadKeys.Button.Y)) {
                m_Superstructure.highPreset();
            }

            //Superstructure manual input toggle - Triggered by holding holding left bumper
            if (Operator.getButton(GamepadKeys.Button.BACK)) {
                m_Superstructure.ManualInput(Operator.getLeftY());
                telemetry.addData(
                        "MANUAL INPUT", "ENABLED");
            }

            //Pincher controls
            if (Operator.getButton(GamepadKeys.Button.LEFT_BUMPER)) {
                m_Superstructure.pincher.open();
            }

            if ((Operator.getTrigger(GamepadKeys.Trigger.LEFT_TRIGGER) > 0.3)) {
                m_Superstructure.pincher.close();
            }

            //Pivot controls
            if (Operator.getButton(GamepadKeys.Button.RIGHT_BUMPER)) {
                m_Superstructure.pincher.setPivotAngleControl(0.1);
            }

            if ((Operator.getTrigger(GamepadKeys.Trigger.RIGHT_TRIGGER) > 0.3)) {
                m_Superstructure.pincher.setPivotAngleControl(-0.1);
            }

            //Wrist controls
            if (Operator.getButton(GamepadKeys.Button.DPAD_UP)) {
                m_Superstructure.pincher.retract();
            }

            if (Operator.getButton(GamepadKeys.Button.DPAD_DOWN)) {
                m_Superstructure.pincher.groundPickup();
            }

            if (Operator.getButton(GamepadKeys.Button.DPAD_LEFT)) {
                m_Superstructure.pincher.wallPickup();
            }

            if (Operator.getButton(GamepadKeys.Button.DPAD_RIGHT)) {
                m_Superstructure.pincher.scoreSample();
            }

            //Presets
            if (Operator.getButton(GamepadKeys.Button.A)) {
                m_Superstructure.groundPickupPreset();
            }

            if (Operator.getButton(GamepadKeys.Button.X)) {
                m_Superstructure.wallPickupPreset();
            }

            if (Operator.getButton(GamepadKeys.Button.B)) {
                m_Superstructure.lowPreset();
            }

            if (Operator.getButton(GamepadKeys.Button.Y)) {
                m_Superstructure.highPreset();
            }

            //Pivot manual control
            if (Math.abs(Operator.getRightX()) > 0){
                m_Superstructure.pincher.setPivotAngle((Operator.getRightX() / 2) + 0.5);
            }





            telemetry.update();
            }
        }
    }

