package javaAdvanced.stacksAndQueues.exercise;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Robot> robots = new ArrayList<>();
        Arrays.stream(scanner.nextLine().split(";")).forEach(element -> {
            Robot robot = new Robot(element.split("-")[0], Integer.parseInt(element.split("-")[1]), 0);
            robots.add(robot);
        });
        int[] timeInput = Arrays.stream(scanner.nextLine().split(":")).mapToInt(Integer::parseInt).toArray();
        int currentTime = timeInput[0] * 3600 + timeInput[1] * 60 + timeInput[2];

        ArrayDeque<String> products = new ArrayDeque<>();

        String product = scanner.nextLine();
        while (!product.equals("End")) {
            products.offer(product);
            product = scanner.nextLine();
        }

        while (!products.isEmpty()) {
            reduceWorkingTime(robots);
            currentTime++;
            boolean productTaken = false;
            String currentProduct = products.poll();
            for (Robot robot : robots) {
                if (isFree(robot)) {
                    robot.setWorkingTime(robot.getProcessingTime());
                    System.out.printf("%s - %s %s%n", robot.getName(), currentProduct, formattedTime(currentTime));
                    productTaken = true;
                    break;
                }
            }
            if (!productTaken) {
                products.offer(currentProduct);
            }
            if (products.size() == 7) {
                System.out.println();
            }
        }
    }

    public static boolean isFree(Robot robot) {
        return robot.getWorkingTime() == 0;
    }

    private static void reduceWorkingTime(List<Robot> robots) {
        for (Robot robot : robots) {
            if (!isFree(robot)) {
                robot.workingTime--;
            }
        }
    }

    public static String formattedTime(int currentTime) {
        int hours = currentTime / 3600 % 24;
        int minutes = currentTime % 3600 / 60;
        int seconds = currentTime % 60;
        return String.format("[%02d:%02d:%02d]", hours, minutes, seconds);
    }

    static class Robot {
        String name;
        int processingTime;
        int workingTime;

        public int getWorkingTime() {
            return workingTime;
        }

        public void setWorkingTime(int workingTime) {
            this.workingTime = workingTime;
        }

        public String getName() {
            return name;
        }

        public int getProcessingTime() {
            return processingTime;
        }

        private Robot(String name, int processingTime, int workingTime) {
            this.name = name;
            this.processingTime = processingTime;
            this.workingTime = workingTime;
        }
    }
}