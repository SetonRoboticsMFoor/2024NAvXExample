
package frc.robot;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends TimedRobot {
  private static final String kDefaultAuto = "Default";
  private static final String kCustomAuto = "My Auto";
  private String m_autoSelected;
  private final SendableChooser<String> m_chooser = new SendableChooser<>();

  // install the Vendor library using online install using the URL below
  //////////////////////////////////////////////////////////////////////

  // https://dev.studica.com/releases/2024/NavX.json

  // Declare a NavX gyro
  private AHRS navXGyro;

  @Override
  public void robotInit() {
    m_chooser.setDefaultOption("Default Auto", kDefaultAuto);
    m_chooser.addOption("My Auto", kCustomAuto);
    SmartDashboard.putData("Auto choices", m_chooser);

    
    // Instantiate the NavX gryo
    navXGyro = new AHRS();

    // Reset the gyro when robot is turned on 
    navXGyro.reset();

  }

  @Override
  public void robotPeriodic() {

    //////////////////////////////////////////////////////
    // Methods that work with the NavX
    /*
     * Connected isConnected()
     * Rate getRate()
     * Yaw getYaw() or getAngle()
     * Pitch getPitch()
     * Roll getRoll()
     * CompassHeading getCompassHeading()
     * FusedHeading getFusedHeading()
     * LinearWorldAccelX getLinearWorldAccelX()
     * LinearWorldAccelY getLinearWorldAccelY()
     * LinearWorldAccelZ getLinearWorldAccelZ()
     */

    // Write the heading, pitch, and roll to the smart dashboard and nothing else

    SmartDashboard.putNumber("Gyro Heading", navXGyro.getAngle());
    SmartDashboard.putNumber("Pitch Value", navXGyro.getPitch());
    SmartDashboard.putNumber("Roll Heading", navXGyro.getRoll());
  }

  @Override
  public void autonomousInit() {
    m_autoSelected = m_chooser.getSelected();
    // m_autoSelected = SmartDashboard.getString("Auto Selector", kDefaultAuto);
    System.out.println("Auto selected: " + m_autoSelected);
  }

  @Override
  public void autonomousPeriodic() {
    switch (m_autoSelected) {
      case kCustomAuto:
        // Put custom auto code here
        break;
      case kDefaultAuto:
      default:
        // Put default auto code here
        break;
    }
  }

  @Override
  public void teleopInit() {
  }

  @Override
  public void teleopPeriodic() {
  }

}
