package Locomotive;

import Exceptions.MaximumCarriageCountExceededException;
    import Exceptions.MaximumElectrifiedCarsCountExceededException;
    import Exceptions.MaximumWeightCapacityExceededException;
    import Exceptions.RailroadHazard;
    import Graph.*;
    import Interfaces.Electricity;
    import Interfaces.Load;
    import Interfaces.Unload;
    import Railways.IDgenerator;
    import Railways.RailwayCar;

    import java.util.ArrayList;
    import java.util.Collections;
    import java.util.List;

    
    //The addRailwayCar method adds a RailwayCar to the locomotive, but checks whether the locomotive has reached its maximum carriage count or maximum weight 
    // capacity first. If adding the car exceeds either of these limits, an exception is thrown. If the car is an instance of Electricity, 
    // it also checks whether the car requires electricity, and if so, whether the maximum number of electrified cars has been exceeded. 
    // If all checks pass, the car is added to the locomotive.
    //
    //The removeRailwayCar method removes a specified RailwayCar from the locomotive. If the car is an instance of Electricity, 
    // it also decrements the number of electrified cars. If the specified car is not in the locomotive, an exception is thrown.
    //
    //The increaseSpeed and decreaseSpeed methods increase and decrease the speed of the locomotive by a factor of 1.03 and 0.97, respectively.
    //
    //The calculateCurrentWeight method calculates the current weight of the locomotive by summing the net and gross weights of all RailwayCars in the locomotive.
    //
    //The getMaxElectrifiedCarsCount and getElectrifiedCarsCount methods return the maximum number of electrified cars allowed on the locomotive and
    // the current number of electrified cars on the locomotive, respectively.
    //
    //The calculateDistanceBetweenStations method calculates the percentage of distance traveled between two stations based on the speed of the locomotive. 
    // It simulates traveling between stations by waiting for a short time, and updates the distance traveled percentage based on the current speed.
    //
    //The checkSpeed method checks whether the locomotive is exceeding the maximum speed, generates a random number, 
    // and increases or decreases the speed of the locomotive depending on the value of the random number. 
    // If a hazard occurs, a RailroadHazard exception is thrown.
    //
    //The run method is the main method for the locomotive class. It first checks whether the stations have been set for the locomotive, 
    // and if not, returns from the method. It then creates a new thread to check the speed of the locomotive and starts it. 
    //It loops through each station in the list of stations, updating the current and next station indices and printing information about
    // the locomotive's speed and current location. It then waits for a short time and moves to the next station. 
    // It also includes several volatile boolean variables to track whether the locomotive is stopped or has encountered a hazard.
    public class Locomotive extends Thread implements Load, Unload {
        private String name;
        private String baseStation;
        private String startStation;
        private String endStation;
        private int id;
        private double speed;
        private double maxWeightCapacity;
        private int maxCarriageCount;
        private int maxElectrifiedCarsCount;
        private int electrifiedCarsCount;
        private ArrayList<RailwayCar> railwayCars = new ArrayList<>();
        private final Graph graph;
        private double distanceBetweenStationsPercent;
        private double distanceTraveledPercent;
        private double allDistance;
        private final List<String> stations;
        private List<Edge> roads;
        private int currentStationIndex = 0;
        private int nextStationIndex = 0;




        public Locomotive(String name, String baseStation, String startStation, String endStation, double maxWeightCapacity, int maxCarriageCount, int maxElectrifiedCarsCount, Graph graph) {
            setId(IDgenerator.getId());
            this.name = name;
            this.baseStation = baseStation;
            this.startStation = startStation;
            this.endStation = endStation;
            this.speed = 100; // km/h
            this.maxWeightCapacity = maxWeightCapacity;
            this.maxCarriageCount = maxCarriageCount;
            this.maxElectrifiedCarsCount = maxElectrifiedCarsCount;
            this.graph = graph;
            distanceTraveledPercent = 0;
            stations = graph.getShortestPath(startStation, endStation); // create my graph here to use it in every place in the code
            if (stations == null) {
                System.err.println("There is no way between " + startStation + " and " + endStation + " so that Locomotive " + getNameLoc() + " can`t go this way");
            } else {
                for (int x = 0; x < stations.size() - 1; x++) {
                    allDistance += graph.getDistance(stations.get(x), stations.get(x + 1)); // getting all distance between start and end station
                }
            }


        }

        public int getCurrentStationIndex() {
            return currentStationIndex;
        }

        public void setCurrentStationIndex(int currentStationIndex) {
            this.currentStationIndex = currentStationIndex;
        }

        public int getNextStationIndex() {
            return nextStationIndex;
        }

        public void setNextStationIndex(int nextStationIndex) {
            this.nextStationIndex = nextStationIndex;
        }

        public double getDistanceTraveled_percent() {
            return distanceTraveledPercent;
        }

        public void setDistanceTraveled_percent(double distanceTraveled_percent) {
            this.distanceTraveledPercent = distanceTraveled_percent;
        }
        public String getNameLoc() {
            return name;
        }

        public void setNameLoc(String name) {
            this.name = name;
        }

        public String getBaseStation() {
            return baseStation;
        }

        public void setBaseStation(String baseStation) {
            this.baseStation = baseStation;
        }

        public String getStartStation() {
            return startStation;
        }

        public void setStartStation(String startStation) {
            this.startStation = startStation;
        }

        public String getEndStation() {
            return endStation;
        }

        public void setEndStation(String endStation) {
            this.endStation = endStation;
        }

        public int getID() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public double getSpeed() {
            return speed;
        }

        public void setSpeed(double speed) {
            this.speed = speed;
        }

        public double getMaxWeightCapacity() {
            return maxWeightCapacity;
        }

        public void setMaxWeightCapacity(double maxWeightCapacity) {
            this.maxWeightCapacity = maxWeightCapacity;
        }

        public int getMaxCarriageCount() {
            return maxCarriageCount;
        }

        public void setMaxCarriageCount(int maxCarriageCount) {
            this.maxCarriageCount = maxCarriageCount;
        }

        public ArrayList<RailwayCar> getRailwayCars() {
            return railwayCars;
        }

        public void setRailwayCars(ArrayList<RailwayCar> railwayCars) {
            this.railwayCars = railwayCars;
        }

        public String getLocomotiveInfo() {
            StringBuilder sb = new StringBuilder();
            sb.append("Locomotive: ").append(name).append("\n");
            sb.append("Base Station: ").append(baseStation).append("\n");
            sb.append("Start Station: ").append(startStation).append("\n");
            sb.append("End Station: ").append(endStation).append("\n");
            sb.append("Speed: ").append(speed).append(" km/h").append("\n");
            try {
                if (stations == null) {
                    sb.append("Stations: null").append("\n");
                } else {
                    sb.append("Current Station: ").append(stations.get(currentStationIndex)).append("\n");
                    sb.append("Next Station: ").append(stations.get(nextStationIndex)).append("\n");
                    sb.append("Distance Traveled: ").append(Math.round(distanceTraveledPercent)).append("%").append("\n");
                    sb.append("Distance Between Stations: ").append(Math.round((distanceBetweenStationsPercent))).append("%").append("\n");
                }
            } catch (NullPointerException e) {
                sb.append("Error: ").append(e.getMessage()).append("\n");
            }
            sb.append("Max Weight Capacity: ").append(maxWeightCapacity).append("\n");
            sb.append("Max Carriage Count: ").append(maxCarriageCount).append("\n");
            sb.append("Max Electrified Cars Count: ").append(maxElectrifiedCarsCount).append("\n");
            sb.append("Electrified Cars Count: ").append(electrifiedCarsCount).append("\n");
            sb.append("Current Weight: ").append(calculateCurrentWeight()).append("\n");
            sb.append("Connected Railway Cars: ").append("\n");
            for (RailwayCar railwayCar : railwayCars) {
                sb.append(railwayCar.toString()).append("\n");
            }
            return sb.toString();
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Locomotive name= ").append(name).append('\n');
            sb.append("Distance Traveled: ").append(Math.round(distanceTraveledPercent)).append('\n');

            for (RailwayCar railwayCar : railwayCars) {
                sb.append(railwayCar.toString()).append("\n");
            }



            return sb.toString();
        }


        public void addRailwayCar(RailwayCar railwayCar) {
            if (railwayCars.size() >= maxCarriageCount) {
                throw new MaximumCarriageCountExceededException("Maximum carriage count reached");
            } else if (calculateCurrentWeight() + railwayCar.getNetWeight() + railwayCar.getGrossWeight() > maxWeightCapacity) {
                throw new MaximumWeightCapacityExceededException("Adding the railway car exceeds the maximum weight capacity");
            } else if (railwayCar instanceof Electricity) {
                if (((Electricity) railwayCar).requiresElectricity()) {
                    if (electrifiedCarsCount >= maxElectrifiedCarsCount) {
                        throw new MaximumElectrifiedCarsCountExceededException("Maximum number of railway cars that need to be connected to the power supply exceeded");
                    } else {
                        railwayCars.add(railwayCar);
                        electrifiedCarsCount++;
                    }
                } else {
                    railwayCars.add(railwayCar);
                }
            } else {
                railwayCars.add(railwayCar);
            }
        }

        public void removeRailwayCar(RailwayCar railwayCar) throws Exception {
            if (!railwayCars.remove(railwayCar)) {
                throw new Exception("The specified railway car is not part of the locomotive");
            }
            if (railwayCar instanceof Electricity) {
                electrifiedCarsCount--;
            }
            railwayCars.remove(railwayCar);
        }

        public void increaseSpeed()  {
            speed = Math.round(speed * 1.03 * 10) / 10.0;

        }

        public void decreaseSpeed() {
            speed = Math.round(speed * 0.97 * 10) / 10.0;

        }

        public double calculateCurrentWeight() {
            double currentWeight = 0;
            for (RailwayCar railwayCar : railwayCars) {
                currentWeight += (railwayCar.getNetWeight() + railwayCar.getGrossWeight());
            }
            return currentWeight;
        }

        public int getMaxElectrifiedCarsCount() {
            return maxElectrifiedCarsCount;
        }

        public int getElectrifiedCarsCount() {
            return electrifiedCarsCount;
        }

        private void calculateDistanceBetweenStations(int stationIndex) {
            // Get the shortest path between start and end stations
            List<String> stations = graph.getShortestPath(startStation, endStation);
            // Get the distance between the current and next station
            double distanceBetweenStations = graph.getDistance(stations.get(stationIndex), stations.get(stationIndex + 1));
            // Calculate the percentage of distance traveled between the two stations
            distanceBetweenStationsPercent = 0;
            while (distanceBetweenStationsPercent < 100) {
                try {
                    // Wait for a short time to simulate traveling between stations
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    // Throw a RuntimeException if the thread is interrupted
                    throw new RuntimeException(e);
                }
                // Calculate the percentage of distance traveled based on the current speed
                distanceBetweenStationsPercent += ((speed * 0.001) / distanceBetweenStations) * 100;
                distanceTraveledPercent += ((speed * 0.001) / allDistance) * 100;
            }
        }

        private volatile boolean stopThread = false;
        private volatile boolean atStation = false;
        private volatile boolean stopAllThreads = false;
        private volatile boolean hazardOccurred = false;




        private void checkSpeed() {
            while (!hazardOccurred) {
                try {
                    if (stopThread) {
                        return;
                    }

                    sleep(1000);
                    synchronized (this) {
                        if (atStation) {
                            wait = true;
                            wait();
                        }
                    }
                    double random = Math.random();
                    if (speed > 200) {
                        throw new RailroadHazard("Locomotive " + getNameLoc() + " exceeds speed 200 km/h", "Locomotive information: " + getLocomotiveInfo());
                    } else if (random < 0.5) {
                        increaseSpeed();
                    } else {
                        decreaseSpeed();
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } catch (RailroadHazard e) {
                    e.printStackTrace();
                    hazardOccurred = true; // stop the main thread
                    return;
                }
            }
        }





        private volatile boolean wait = false;


        public void run() {
            if (stations == null) {
                return; // Exit the method
            }
            while (true) {
                try {
                    if (stopAllThreads) {
                        return; // Stop the thread
                    }
                    hazardOccurred = false;
                    Thread checkSpeed = new Thread(() -> checkSpeed());
                    checkSpeed.start();

                    for (int i = 0; i < stations.size() - 1; i++) {

                        currentStationIndex = i;
                        nextStationIndex = i+1;
                        System.out.println("Speed " + getNameLoc() + " = " + String.format("%.1f", speed)); // Округление скорости до одного знака после запятой
                        synchronized (this) {
                            wait = false;
                        }
                            System.out.println(name + " is now in the city "+ stations.get(i));
                        String from = stations.get(i);
                        String to = stations.get(i + 1);

                        roads = graph.getRoadsBetweenCities(from, to);
                        for (Edge road : roads) {
                            synchronized (road) {
                                while (wait) {
                                    wait();
                                }
                                sleep(2000);
                                graph.blockRoad(from, to);
                                System.out.println(getNameLoc() + " is between " + from + " and " + to);
                                calculateDistanceBetweenStations(i);
                                System.out.println(name + " comes up to the station " + stations.get(i+1));
                                sleep(2000);
                                System.out.println(name + " arrived to the station " + stations.get(i+1));
                                // Move along the road here...
                                System.out.println(getNameLoc()  + " left the road between " + from + " and " + to);
                                graph.unblockRoad(from, to);
                                sleep(2000);
                                if (stations.get(i + 1).equals(endStation) || stations.get(i + 1).equals(startStation)) {
                                System.out.println(name + " unloading at the station " + stations.get(i + 1));
                                unload();
                                break;
                            } else {
                                System.out.println(name + " waiting for the load on the station " + stations.get(i + 1));
                                load();
                                break;
                            }
                            }
                        }
                    }

                    System.out.println(getNameLoc() + " has reached its destination and will wait for 30 seconds");
                    synchronized (this) {
                        atStation = true;
                        wait = true;
                    }
                    checkSpeed.sleep(30000);
                    synchronized (this) {
                        atStation = false;
                        wait = false;
                    }
                    distanceTraveledPercent = 0;
                    Collections.reverse(roads);
                    Collections.reverse(stations);

                    if (hazardOccurred) {
                        stopAllThreads = true;
                        break;
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        @Override
        public void load() {
            for (RailwayCar rw : railwayCars){
                rw.load();
            }
        }

        @Override
        public void unload() {
            for (RailwayCar rw : railwayCars){
                rw.unload();
            }
        }
    }




