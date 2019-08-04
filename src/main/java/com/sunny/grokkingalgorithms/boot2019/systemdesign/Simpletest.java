package com.sunny.grokkingalgorithms.boot2019.systemdesign;

public class Simpletest {

    public static void main(String[] args) {
        String s = "select distinct \n" +
                " agent_group_id,  \n" +
                " agent_group_name,\n" +
                "sum(job_count) as job_count\n" +
                "from opi.opi_summary_job_count_hourly\n" +
                "where \n" +
                "state in (1,2,3) and\n" +
                "org_uuid = :org_uuid\n" +
                "and end_day_hour >= convert_timezone('EDT', (select timestamp 'epoch' + :startTime  * interval '1 second')) \n" +
                "and end_day_hour < convert_timezone('EDT', (select timestamp 'epoch' + :endTime  * interval '1 second'))  \n" +
                "group by agent_group_name,agent_group_id \n" +
                "order by job_count desc \n" +
                ";";
        System.out.println(s);

    }
}
