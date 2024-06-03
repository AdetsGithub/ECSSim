# ECSSim

Welcome to ECSSim.

This is a simulator which simulates a University

My extension takes into account the fact that some facilities will fall into disrepair through the years.

I have implemented a demolishFacilities() method
age is a variable of Facility
increaseAge() is a method used to increase the age defined in Facility
getAge() returns the age of the facility
demolishFacilities() is a method defined in estate
Facility is demolished if age exceeds 15 or by random chance
demolishedFacilities() decreases budget and reputation by 50

I have implemented a renovate() method which increases the life expectancy of the building.
age is decreased by 6 or to 0 when age < 5
renovate() method defined in Facility
renovate() method decreases budget by 70 and increases reputation by 50

My extension also contains two new facilities (Gym and Shop)

All properties and methods involving facilities have been adapted accordingly in relevant methods and classes
Since introducing the two new buildings, rate of growth of reputation and rate of growth of remaining budget have decreased over the same time period
My original coursework runs for 52 years before reaching an average end of year budget of 6300 and average reputation of 112000 before there are no remaining staff
My extension runs for 84 years and before reaching an average end of year budget of 6100 and average reputation of 178000 before there are no remaining staff
