# PriorityQueue


    PriorityQueue<String> priorityQueue = new PriorityQueue<>(new Comparator<String>() {

                @Override
                public int compare(String o1, String o2) {
                    if(o1.charAt(1) < o2.charAt(1)) {
                        return -1;
                    }else if(o1.charAt(1) > o2.charAt(1)) {
                        return 1;
                    }else {
                        return 0;
                    }

                    /*
                    return o1.compareTo(o2);            //전체 오름 차순
                    return o2.compareTo(o1);            //전체 내림차순
                    */
                }
            });
