/**
 * Copyright CSIRO Australian e-Health Research Centre (http://aehrc.com).
 * All rights reserved. Use is subject to license terms and conditions.
 */
package au.csiro.snorocket.core.benchmark;

/**
 * Runs both benchmarks using predefined parameters.
 * 
 * @author Alejandro Metke
 *
 */
public class SimpleBenchmark {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Benchmark.main(new String[] {"RF1", "5"});
        
        BenchmarkIncremental.main(new String[] {"RF1", 
                "sct1_Concepts_Core_INT_20110731_base.txt", 
                "res1_StatedRelationships_Core_INT_20110731_base.txt", 
                "sct1_Concepts_Core_INT_20110731_inc.txt", 
                "res1_StatedRelationships_Core_INT_20110731_inc.txt", 
                "20110731", 
                "5"});

    }

}
