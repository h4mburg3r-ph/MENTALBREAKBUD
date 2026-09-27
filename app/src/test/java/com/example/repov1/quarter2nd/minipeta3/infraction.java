package com.example.repov1.quarter2nd.minipeta3;

import java.time.LocalDateTime;
// step 1 by lim

    public class infraction{
        private String infractionName;
        private int infractionDegree;
        private LocalDateTime infractionTime;

        public infraction(String name, int degree, LocalDateTime time) {
            this.infractionName = name;
            this.infractionDegree = degree;
            this.infractionTime = time;
        }

        public String toString() {
            return "Offense: " + infractionName + ", Degree: " + String.valueOf(infractionDegree) + ", Time of Recording: " + String.valueOf(infractionTime);
        }


    }



