package org.firstinspires.ftc.teamcode.auto;

    import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
    import com.arcrobotics.ftclib.gamepad.GamepadEx;
    import org.firstinspires.ftc.robotcore.external.Telemetry;
    import org.firstinspires.ftc.teamcode.MecanumDrive;
    import org.firstinspires.ftc.teamcode.subsystems.MecanumDriveSubsystem;
    import org.firstinspires.ftc.teamcode.subsystems.SuperstructureSubsystem;
    import com.qualcomm.robotcore.eventloop.opmode.Autonomous;


@Autonomous(name = "TestAuto")
public class TestAuto extends LinearOpMode{

        private SuperstructureSubsystem m_SuperStructure;
        private MecanumDriveSubsystem m_Drive;
        private Telemetry telemetry;


        public void runOpMode() {
            m_Drive = new MecanumDriveSubsystem(hardwareMap, telemetry);
            m_SuperStructure = new SuperstructureSubsystem(hardwareMap, telemetry);

        }

}
