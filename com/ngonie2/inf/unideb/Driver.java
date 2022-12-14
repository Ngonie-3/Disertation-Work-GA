/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ngonie2.inf.unideb;
import java.util.ArrayList;
import com.ngonie1.inf.unideb.Class;

/**
 *
 * @author ngoni
 */
public class Driver {

    /**
     * @param args the command line arguments
     */
    
    public static final int POPULATION_SIZE = 9;
    public static final double MUTATION_RATE = 0.1;
    public static final double CROSSOVER_RATE = 0.9;
    public static final int TOURNAMENT_SELECTION_SIZE = 3;
    public static final int NUMB_OF_ELITE_SCHEDULES = 1;
    private int scheduleNumb = 0;
    private int classNumb = 1;
    private Data data;
    
    public static void main(String[] args) {
        Driver ucsp = new Driver();
        ucsp.data = new Data();
        int generationNumber = 0;
        ucsp.printAvailableData();
        System.out.println("Generation No. " +generationNumber);
        System.out.print("Schedule Number   |                                  ");
        System.out.print("                        Classes [dept,class,room,lecturer,metting-time]   ");
        System.out.println("                                             " + "                         | Fitness  | Conflicts");
        System.out.print("-----------------------------------------------------------------------------------------------------------------");
        System.out.println("----------------------------------------------------------------------------------------------------------");//bottom
        GeneticAlgorithm geneticAlgorithm = new GeneticAlgorithm(ucsp.data);
        Population population = new Population(Driver.POPULATION_SIZE, ucsp.data).sortByFitness();
        population.getSchedules().forEach(schedule -> System.out.println("              "+ucsp.scheduleNumb++ +"   |  "+ schedule +"  "
                                                + "|  "+ String.format("%.5f", schedule.getFitness()) + " | "+schedule.getNumbOfConflicts()));
        ucsp.printScheduleAsTable(population.getSchedules().get(0), generationNumber);
        ucsp.classNumb = 1;
        while (population.getSchedules().get(0).getFitness() != 1.0){
            System.out.println("#Generation No. "+ ++generationNumber);
            System.out.print("Schedule Number   |                                  ");
            System.out.print("                        Classes [dept,class,room,lecturer,metting-time]   ");
            System.out.println("                                         " + "                           | Fitness  | Conflicts");
            System.out.print("----------------------------------------------------------------------------------------------------------------------------------------------------");//schedule top
            System.out.println("-------------------------------------------------------------------------");//table bottom
            population = geneticAlgorithm.evolve(population).sortByFitness();
            ucsp.scheduleNumb = 0;
            population.getSchedules().forEach(schedule -> System.out.println("         "+ucsp.scheduleNumb++ +
                                                                             "        | "+schedule + " | " +
                                                                              String.format("%.5f", schedule.getFitness()) + 
                                                                              "  |  "+schedule.getNumbOfConflicts()));
            ucsp.printScheduleAsTable(population.getSchedules().get(0), generationNumber);
            ucsp.classNumb = 1;
        }
    }
    
    private void printAvailableData(){
        System.out.println("Available Departments ->");
        data.getDepartment().forEach(x-> System.out.println("Name: "+x.getName()+", courses: "+x.getCourses()));
        
        System.out.println("\nAvailable Courses ->");
        data.getCourses().forEach(x-> System.out.println("Course No. "+x.getNumber()+", name: "+x.getName()+", max headcount: "+x.getMaxNumberOfStudnets()+", lecturers: "+x.getLecturers()));
        
        System.out.println("\nAvailable Rooms ->");
        data.getRooms().forEach(x-> System.out.println("Room No. "+x.getNumber()+", max seating capacity: "+x.getSeatingCapacity()));
        
        System.out.println("\nAvailable Lecturers ->");
        data.getLecturers().forEach(x-> System.out.println("Lecturer id: "+x.getId()+", name: "+x.getName()));
        
        System.out.println("\nAvailable Meeting Times ->");
        data.getMeetingTime().forEach(x-> System.out.println("Time Id: "+x.getId()+", meeting Time: "+x.getTime()));
        System.out.print("--------------------------------------------------------------------------------------------------");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------");
    }
    
    private void printScheduleAsTable(Schedule schedule, int generation){
        ArrayList<Class> classes = schedule.getClasses();
        System.out.print("\n                        ");
        System.out.println("Class No. |  Department  |  Course (number, max No. of students) |  Room (Capacity)  |   Lecturer (Id)       |  Meeting Time (Id)");
        System.out.print("                       "); 
        System.out.print("-------------------------------------------------------------------------------------");
        System.out.println("------------------------------------------------------------");
        classes.forEach(x ->{
            int majorIndex = data.getDepartment().indexOf(x.getDepartment());
            int courseIndex = data.getCourses().indexOf(x.getCourse());
            int roomsIndex = data.getRooms().indexOf(x.getRoom());
            int lecturerIndex = data.getLecturers().indexOf(x.getLecturer());
            int meetingTimeIndex = data.getMeetingTime().indexOf(x.getMeetingTime());
            System.out.print("                 ");
            System.out.print(String.format("       %1$4d  ", classNumb)+ "    | ");
            System.out.print(String.format(" %1$5s ", data.getDepartment().get(majorIndex).getName())+"| ");
            System.out.print(String.format("%1$26s ", data.getCourses().get(courseIndex).getName()+ " ("+data.getCourses().get(courseIndex).getNumber()+", "+x.getCourse().getMaxNumberOfStudnets())+")          |   ");
            System.out.print(String.format("%1$10s", data.getRooms().get(roomsIndex).getNumber() + " ("+x.getRoom().getSeatingCapacity()) + ")     |  ");
            System.out.print(String.format("%1$18s ", data.getLecturers().get(lecturerIndex).getName()+ " ("+data.getLecturers().get(lecturerIndex).getId())+")|");
            System.out.print(String.format(" %1$20s ",data.getMeetingTime().get(meetingTimeIndex).getTime()+" ("+data.getMeetingTime().get(meetingTimeIndex).getId()+")"));
            System.out.println("");
            classNumb++;
        });
        if(schedule.getFitness() == 1) System.out.println("#Solution found in "+(generation + 1) +" generations");
        System.out.print("-----------------------------------------------------------------------------------");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
    }
}
