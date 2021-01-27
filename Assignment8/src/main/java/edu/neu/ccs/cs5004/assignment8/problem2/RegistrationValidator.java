package edu.neu.ccs.cs5004.assignment8.problem2;

import java.util.Calendar;

/**
 * Represents a RegistrationValidator class.
 * To check if a ProspectiveDriver can become an AcceptedDriver.
 */
public class RegistrationValidator {
  public static final Integer LEGAL_AGE = 21;
  public static final Integer THIS_YEAR = Calendar.getInstance().get(Calendar.YEAR);
  public static final Integer THIS_MON = Calendar.getInstance().get(Calendar.MONTH);
  public static final Integer THIS_DATE = Calendar.getInstance().get(Calendar.DATE);

  /**
   * a main function to check all checking points for accepting a prospective driver
   * @param applicant the prospective driver who is making application
   * @return true if applicant pass all checking points, otherwise return false.
   */
  public static Boolean isApplicantAccepted(ProspectiveDriver applicant) {
    return (RegistrationValidator.isAcceptedByCheckingAge(applicant.getAge())
        && RegistrationValidator.isAcceptedByCheckingDriverLicenseInfo(applicant)
        && RegistrationValidator.isAcceptedByCheckingVehicleYear(applicant.getVehicle().getYear())
        && RegistrationValidator.isAcceptedByCheckingVehicleInsuranceInfo(applicant)
        && RegistrationValidator.isAcceptedByCheckingDriverHistory(applicant.getDriverHistory())
        && RegistrationValidator.isAcceptedByCheckingVehicleHistory(applicant.getVehicleHistory()));
  }

  //--------------Prospective driver’s age--------------
  /**
   * To check the age of a prospective driver. If the prospective driver is equal or over 21, return
   * true.. Otherwise return false and driver is not accepted.
   *
   * @return true if driver age is over 21, otherwise false.
   */
  public static Boolean isAcceptedByCheckingAge(Integer age) {
    return age >= LEGAL_AGE ;
  }

  //--------------Prospective driver’s license information--------------
  /**
   * A function to use all related helper function to check driver license info
   *
   * @return true if driver pass the driver license info check, otherwise false.
   */
  public static Boolean isAcceptedByCheckingDriverLicenseInfo(AbstractDriver applicant) {
    return (RegistrationValidator.isNameSameAsLicense(applicant.getName(), applicant.getDriverLicense().getName())
        && RegistrationValidator.isDateOfBirthSameAsLicense(applicant.getDateOfBirth(), applicant.getDriverLicense().getDateOfBirth())
        && RegistrationValidator.isUSLicense(applicant.getDriverLicense().getCountry())
        && RegistrationValidator.isDriverLicenseIssuedMoreThan6Month(applicant.getDriverLicense().getIssueDate())
        && RegistrationValidator.isDriverLicenseNotExpired(applicant.getDriverLicense().getExpiration()));
  }

  /**
   * To check if a prospective driver's provided name is as same as it's on driver license. If name
   * is matched, return true. Otherwise false and the driver is not accepted.
   *
   * @param providedName the name prospective driver provided in the application.
   * @param nameOnDriverLicense the name on his/her driver license
   * @return true if the names are same, otherwise false.
   */
  public static Boolean isNameSameAsLicense(Name providedName, Name nameOnDriverLicense) {
    return providedName.equals(nameOnDriverLicense);
  }

  /**
   * To check if a prospective driver's provided date of birth is as same as it's on driver license.
   * If date of birth are same, return true. Otherwise return false and the driver is not accepted.
   *
   * @param providedDateOfBirth the DOB prospective driver provided in the application.
   * @param dateOfBirthOnDriverLicense the DOB on his/her driver license
   * @return true if the DOB are same, otherwise false.
   */
  public static Boolean isDateOfBirthSameAsLicense(Date providedDateOfBirth,
      Date dateOfBirthOnDriverLicense) {
    return providedDateOfBirth.equals(dateOfBirthOnDriverLicense);
  }

  /**
   * To check if the provided driver license is issued in US. If the license country is US, return
   * true. Otherwise return false and driver is not accepted.
   *
   * @param countryOnLicense the country name on the driver license.
   * @return true if it is US driver license, otherwise false.
   */
  public static Boolean isUSLicense(String countryOnLicense) {
    return countryOnLicense.equals("US") ;
  }

  /**
   * To check if the driver license issued more than six months. If issued more than 6 month, return
   * true. Otherwise return false and driver is not accepted.
   *
   * @param issueDate issue date of the driver license
   * @return true if driver license issued more than six month, otherwise false.
   */
  public static Boolean isDriverLicenseIssuedMoreThan6Month(Date issueDate) {
    return RegistrationValidator.isDateMoreThan6MonthAgo(issueDate);
  }


  /**
   * a helper function to check if a date is more than 6 month ago to today.
   * @param date the date to check
   * @return true if the date is over 6 month ago, otherwise false.
   */
  private static Boolean isDateMoreThan6MonthAgo(Date date) {
    // case 1: today's year is the next year of issue date, but within 6 month
    if (THIS_YEAR - date.getYear() == 1) {
      if ((12 + THIS_MON - date.getMonth()) <= 6) {
        return false;
      }
      // case 2: the license issued in this year, within 6 month
    } else if (THIS_YEAR == date.getYear() && THIS_MON - date.getMonth() <= 6) {
      return false;
    }
    return true;
  }


  /**
   * To check if the driver license is not expired. If the driver license is not expired, return
   * true. Otherwise return false and driver not accepted.
   *
   * @param expiration the date of expiration
   * @return true if expiration date is before today, otherwise false.
   */
  public static Boolean isDriverLicenseNotExpired(Date expiration) {
    return RegistrationValidator.isNotExpired(expiration);
  }

  /**
   * helper function to check if a Date is expired or not.
   * @param expiration the date of expiration
   * @return true if not expired, otherwise false.
   */

  private static Boolean isNotExpired(Date expiration) {
    if (expiration.getYear() > THIS_YEAR) {
      return true;
    }
    if (expiration.getYear() == THIS_YEAR && expiration.getMonth() > THIS_MON) {
      return true;
    }
    if (expiration.getYear() == THIS_YEAR
        && expiration.getMonth() == THIS_MON
        && expiration.getDay() > THIS_DATE) {
      return true;
    }
    return false;
  }
  //--------------Vehicle information--------------
  /**
   * To check if vehicle is less than 20 year.
   * If the vehicle is less than 20 years, return true.
   * Otherwise return false and driver not accepted.
   *
   * @param vehicleYear vehicle made year
   * @return true if less than 20 years, otherwise false.
   */

  public static Boolean isAcceptedByCheckingVehicleYear(int vehicleYear) {
    return THIS_YEAR - vehicleYear < 20 ;
  }

  //--------------Vehicle insurance information--------------
  /**
   * A function to check vehicle insurance info to see if driver is acceptable. Will use
   * isDriverTheOwnerInInsurance() and isInsuranceNotExpired() as helper function.
   *
   * @return true if driver is accepted after checking vehicle insurance info
   */
  public static Boolean isAcceptedByCheckingVehicleInsuranceInfo(AbstractDriver applicant) {
    return (RegistrationValidator.isDriverTheOwnerInInsurance(applicant.getName(),
        applicant.getVehicleInsurance())
       && RegistrationValidator.isInsuranceNotExpired(
           applicant.getVehicleInsurance().getExpiration()));
  }

  /**
   * To check if the prospective driver is the owner of the vehicle or in insured other driver list.
   * If the driver is the owner or in the other driver list of this vehicle insurance, return true.
   * Otherwise return false and the driver is not accepted.
   *
   * @param driverProvidedName driver provided name
   * @param insurance the insurance info of the vehicle
   * @return true is driver is owner or insured driver of the vehicle, otherwise false.
   */
  public static Boolean isDriverTheOwnerInInsurance(Name driverProvidedName, VehicleInsurance insurance) {
    return (driverProvidedName == insurance.getOwner() || insurance.getOtherDrivers().contains(driverProvidedName));
  }

  /**
   * To check if the vehicle insurance is not expired. If it is not expired, return true. Otherwise
   * return false and drive is not accepted
   *
   * @param insuranceExpiration insurance expiration date
   * @return true if insurance not expired, otherwise false
   */
  public static Boolean isInsuranceNotExpired(Date insuranceExpiration) {
    return RegistrationValidator.isNotExpired(insuranceExpiration);
  }

  //--------------Driver’s history--------------
  /**
   * To check the driver moving violation status in driver's history. If driver does not have moving
   * violation now, or the moving violation is not include: reckless driving, speeding, DUI, or
   * driving without a valid license/insurance, return true. Otherwise return false and driver is
   * not accepted.
   *
   * @param driverHistory driver history
   * @return true is driver is acceptable after checking driver history, otherwise false.
   */
  public static Boolean isAcceptedByCheckingDriverHistory(DriverHistory driverHistory) {
    if (driverHistory.getMovingViolation() == null) {
      return true;
    } else {
      if (driverHistory.getMovingViolation() == MovingViolation.RecklessDriving
          || driverHistory.getMovingViolation() == MovingViolation.Speeding
          || driverHistory.getMovingViolation() == MovingViolation.DrivingUnderInfluence
          || driverHistory.getMovingViolation() == MovingViolation.DrivingWithoutlicense) {
        return false;
      }
      return true;
    }
  }

  //--------------Vehicle’s history--------------
  /**
   * To check any crashes or moving violations committed with this vehicle in the last six months.
   * If there is, return false and driver is not accepted. Otherwise return true.
   */
  public static Boolean isAcceptedByCheckingVehicleHistory(VehicleHistory vehicleHistory) {
    if (vehicleHistory.getDate() == null
        || RegistrationValidator.isDateMoreThan6MonthAgo(vehicleHistory.getDate())) {
      return true;
    } else {
      if (vehicleHistory.getCrash() == null && vehicleHistory.getMovingViolation() == null) {
        return true;
      }
    }
    return false;
  }
}
