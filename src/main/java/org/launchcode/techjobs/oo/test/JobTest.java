package org.launchcode.techjobs.oo.test;


import org.launchcode.techjobs.oo.Employer;
import org.launchcode.techjobs.oo.Location;
import org.launchcode.techjobs.oo.PositionType;
import org.launchcode.techjobs.oo.CoreCompetency;
import org.launchcode.techjobs.oo.Job;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;



/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    @Test
    public void testSettingJobId(){
        Job test_job1 = new Job();
        Job test_job2 = new Job();
        assertNotEquals(test_job1,test_job2);
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        Job test_job_all = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertTrue(test_job_all.getName() instanceof String);
        assertTrue(test_job_all.getEmployer() instanceof Employer);
        assertTrue(test_job_all.getLocation() instanceof Location);
        assertTrue(test_job_all.getPositionType() instanceof PositionType);
        assertTrue(test_job_all.getCoreCompetency() instanceof CoreCompetency);

        assertEquals(test_job_all.getName(), "Product tester");
        assertEquals(test_job_all.getEmployer().getValue(), "ACME");
        assertEquals(test_job_all.getLocation().getValue(), "Desert");
        assertEquals(test_job_all.getPositionType().getValue(), "Quality control");
        assertEquals(test_job_all.getCoreCompetency().getValue(), "Persistence");
    }

    @Test
    public void testJobsForEquality(){
        Job test_job_all = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job test_job_all2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));


        assertFalse(test_job_all.equals(test_job_all2 ));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        Job test_job_all = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertEquals(test_job_all.toString().charAt(0),'\n');
        assertEquals(test_job_all.toString().charAt(test_job_all.toString().length()-1),'\n');

    }

    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job test_job_all = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

     assertEquals(test_job_all.toString(), "\n"+"ID: " + test_job_all.getId() + "\n" +
                "Name: Product tester" + "\n" +
                "Employer: ACME" + "\n" +
                "Location: Desert" + "\n" +
                "Position Type: Quality control" + "\n" +
                "Core Competency: Persistence" + "\n");

    }

    @Test
    public void testToStringHandlesEmptyField(){
        Job test_job_missingInfo = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));

        assertEquals(test_job_missingInfo.toString(), "\n"+"ID: " + test_job_missingInfo.getId() + "\n" +
                "Name: Data not available" + "\n" +
                "Employer: Data not available" + "\n" +
                "Location: Data not available" + "\n" +
                "Position Type: Data not available" + "\n" +
                "Core Competency: Data not available" + "\n");

    }



}
