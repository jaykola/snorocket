/**
 * Copyright (c) 2009 International Health Terminology Standards Development
 * Organisation
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/**
 * Copyright CSIRO Australian e-Health Research Centre (http://aehrc.com).
 * All rights reserved. Use is subject to license terms and conditions.
 */

package au.csiro.snorocket;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.UUID;

import org.junit.Test;

public class TestRegression {
    final static String TEST_DIR = "src/test/files/";

    /* **************************************************************************
     * To successfully run, testSnomedStated201001() requires  
     *   1. sufficient real (non-virtual) memory, and
     *   2. access to SNOMED files.
    ***************************************************************************

    @Test
    public void testSnomedStated201001() throws NumberFormatException,
            IOException {
        final String THIS_TEST_DIR = TEST_DIR + "2010-01-31/";
        final String concepts = THIS_TEST_DIR + "sct_concepts_20100131.txt";
        final String stated = THIS_TEST_DIR
                + "sct_relationships_stated_20100131.txt";
        final String distribution = THIS_TEST_DIR
                + "sct_relationships_inferred_20100131.txt";
        final String output = THIS_TEST_DIR
                + "sct_relationships_output_20100131.txt";
        try {
            final long start = System.currentTimeMillis();

            final String[] args = { "--Xdebug", "--conceptsFile", concepts,
                    "--relationshipsFile", stated, "--outputFile", output };

            au.csiro.snorocket.core.Snorocket.DEBUG_DUMP = true;
            Main.main(args);
            au.csiro.snorocket.core.Snorocket.DEBUG_DUMP = false;

            final SortedSet<Rel> rels1 = loadRelationships(output);
            final SortedSet<Rel> rels2 = loadRelationships(distribution);

            System.err.println((System.currentTimeMillis() - start) + " ms");
            final int size1 = rels1.size();
            System.err.println("rel1 count: " + size1);
            final int size2 = rels2.size();
            System.err.println("rel2 count: " + size2);

            diffRels(rels1, rels2);

            dumpRelationships(rels1, "RocketOutput_compare_20100131.txt");
            dumpRelationships(rels2, "RocketDistro_compare_20100131.txt");
        } finally {
            // clean up
            new File(output).delete();
        }
        System.err.println("::: COMPLETED 2010-01-31 FULL CLASSIFICATION");
    }
    ***************************************************************************/

    /* **************************************************************************
    * To successfully run, testSnomedStated200907() requires  
    *   1. sufficient real (non-virtual) memory, and
    *   2. access to SNOMED files.
    ***************************************************************************
    @Test
    public void testSnomedStated200907() throws NumberFormatException,
            IOException {
        final String THIS_TEST_DIR = TEST_DIR + "2009-07-31/";
        final String concepts = THIS_TEST_DIR + "sct_concepts_20090731.txt";
        final String stated = THIS_TEST_DIR
                + "sct_relationships_stated_20090731.txt";
        final String distribution = THIS_TEST_DIR
                + "sct_relationships_inferred_20090731.txt";
        final String output = THIS_TEST_DIR
                + "sct_relationships_output_20090731.txt";
        try {
            final long start = System.currentTimeMillis();

            final String[] args = { "--Xdebug", "--conceptsFile", concepts,
                    "--relationshipsFile", stated, "--outputFile", output };

            Main.main(args);

            final SortedSet<Rel> rels1 = loadRelationships(output);
            final SortedSet<Rel> rels2 = loadRelationships(distribution);

            System.err.println((System.currentTimeMillis() - start) + " ms");
            final int size1 = rels1.size();
            System.err.println("rel1 count: " + size1);
            final int size2 = rels2.size();
            System.err.println("rel2 count: " + size2);

            diffRels(rels1, rels2);

            dumpRelationships(rels1, "RocketOutput_compare_20090731.txt");
            dumpRelationships(rels2, "RocketDistro_compare_20090731.txt");
        } finally {
            // clean up
            new File(output).delete();
        }
        System.err.println("::: COMPLETED 2009-07-31 FULL CLASSIFICATION");
    }
    ***************************************************************************/

    /*    ***************************************************************************/

    /* **************************************************************************
     * To successfully run, testSnomedStated200901() requires  
     *   1. sufficient real (non-virtual) memory, and
     *   2. access to SNOMED files.
     ****************************************************************************  
    	@Test
    	public void testSnomedStated200901() throws NumberFormatException,
    			IOException {
    		final String concepts = TEST_DIR + "sct_concepts_20090131.txt";
    		final String stated = TEST_DIR
    				+ "sct_relationships_stated_20090131.txt";
    		final String distribution = TEST_DIR + "sct_relationships_20090131.txt";
    		final String inferred = TEST_DIR
    				+ "sct_relationships_inferred_20090131.txt";
    		try {
    			final long start = System.currentTimeMillis();

    			final String[] args = { "--Xdebug", "--conceptsFile", concepts,
    					"--relationshipsFile", stated, "--outputFile", inferred };

    			Main.main(args);

    			final SortedSet<Rel> rels1 = loadRelationships(inferred);
    			final SortedSet<Rel> rels2 = loadRelationships(distribution);

    			System.err.println((System.currentTimeMillis() - start) + " ms");
    			final int size1 = rels1.size();
    			System.err.println("rel1 count: " + size1);
    			final int size2 = rels2.size();
    			System.err.println("rel2 count: " + size2);

    			diffRels(rels1, rels2);
    		} finally {
    			// clean up
    			new File(inferred).delete();
    		}
    	}
     ***************************************************************************/

    @Test
    public void testTest1() throws NumberFormatException, IOException {
        final String A = "X";
        final String B = "Y";

        checkDiff(A, B, 0);
    }

    @Test
    public void testTest2() throws NumberFormatException, IOException {
        final String A = "A1.txt";
        final String B = "A2.txt";

        checkDiff(A, B, 3);
    }

    /* **************************************************************************
     * To successfully run, testRegression20070731() requires  
     *   1. sufficient real (non-virtual) memory, and
     *   2. access to SNOMED files.
     ****************************************************************************  
    	@Test
    	public void testRegression20070731() throws NumberFormatException,
    			IOException {
    		final String c = TEST_DIR + "sct_concepts_20070731.txt";
    		final String r = TEST_DIR + "sct_relationships_20070731.txt";
    		classifyAndDiff(c, r);
    	}
    */

    /* **************************************************************************
     * To successfully run, testRegression20080731() requires  
     *   1. sufficient real (non-virtual) memory, and
     *   2. access to SNOMED files.
     ****************************************************************************  
    	@Test
    	public void testRegression20080731() throws NumberFormatException,
    			IOException {
    		final String c = TEST_DIR + "sct_concepts_20080731.txt";
    		final String r = TEST_DIR + "sct_relationships_20080731.txt";
    		classifyAndDiff(c, r);
    	}
    */

    private void classifyAndDiff(final String c, final String r)
            throws NumberFormatException, IOException {
        final String o = "rels.txt";
        try {
            final long start = System.currentTimeMillis();

            final String[] args = { "--Xdebug", "--conceptsFile", c,
                    "--relationshipsFile", r, "--outputFile", o };

            // Main.main(new String[] {"--Xdebug", "--noHeader",
            // "--conceptsFile", "/dev/null", "--relationshipsFile",
            // "/dev/null"});

            Main.main(args);

            final SortedSet<Rel> rels1 = loadRelationships(r);
            final SortedSet<Rel> rels2 = loadRelationships(o);

            System.err.println((System.currentTimeMillis() - start) + " ms");
            final int size1 = rels1.size();
            System.err.println("rel1 count: " + size1);
            final int size2 = rels2.size();
            System.err.println("rel2 count: " + size2);

            diffRels(rels1, rels2);
        } finally {
            // clean up
            new File(o).delete();
        }
    }

    private void checkDiff(final String A, final String B, final int expected)
            throws IOException {
        final long start = System.currentTimeMillis();

        final SortedSet<Rel> rels1 = loadRelationships(TEST_DIR + A);
        final SortedSet<Rel> rels2 = loadRelationships(TEST_DIR + B);

        System.err.println((System.currentTimeMillis() - start) + " ms");
        System.err.println("rel1 count: " + rels1.size());
        System.err.println("rel2 count: " + rels2.size());
        System.err.flush();

        // int count = 0;
        // for (Rel rel: rels1) { count++; System.out.println(count + ": " +
        // rel); }
        // System.out.println("----");
        // count = 0;
        // for (Rel rel: rels2) {count++; System.out.println(count + ": " +
        // rel); }
        // System.out.println("----");
        // System.out.flush();

        final int numDiffs = diffRels(rels1, rels2);

        assertEquals(expected, numDiffs);
    }

    private int diffRels(final SortedSet<Rel> rels1, final SortedSet<Rel> rels2) {
        final Iterator<Rel> itr1 = rels1.iterator();
        final Iterator<Rel> itr2 = rels2.iterator();

        Rel rel1 = itr1.next();
        Rel rel2 = itr2.next();

        int count = 0, diffs = 0;

        while (itr1.hasNext() && itr2.hasNext()) {
            final int cmp = rel1.compareTo(rel2);
            // System.err.println(cmp + " * " + rel1 + " * " + rel2);
            count++;

            if (0 == cmp) {
                rel1 = itr1.next();
                rel2 = itr2.next();
            } else if (cmp < 0) {
                diffs++;
                System.err.println(count + " A< " + rel1);
                System.err.println(count + " B< " + rel2);
                rel1 = itr1.next();
            } else {
                diffs++;
                System.err.println(count + " A> " + rel1);
                System.err.println(count + " B> " + rel2);
                rel2 = itr2.next();
            }
        }

        while (itr1.hasNext()) {
            diffs++;
            System.err.println("A: " + itr1.next());
        }

        while (itr2.hasNext()) {
            diffs++;
            System.err.println("B: " + itr2.next());
        }

        System.err.println("### Num items: " + count + ", " + diffs);

        return diffs;
    }

    private void dumpRelationships(SortedSet<Rel> rels, final String filename)
            throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(filename));

        for (Rel r : rels) {
            bw.write(getSnomedUuid(r._c1) + "\t" + getSnomedUuid(r._r) + "\t"
                    + getSnomedUuid(r._c2) + "\r\n");
        }
        bw.close();
    }

    private static final String encoding = "8859_1";

    private UUID getSnomedUuid(String id) {
        String name = "org.snomed." + id;
        try {
            return UUID.nameUUIDFromBytes(name.getBytes(encoding));
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }

    private SortedSet<Rel> loadRelationships(final String filename)
            throws NumberFormatException, IOException {
        final BufferedReader relationships = new BufferedReader(new FileReader(
                filename));
        final SortedSet<Rel> result = new TreeSet<Rel>();

        relationships.readLine();

        String line;
        while (null != (line = relationships.readLine())) {
            if (line.contains("RELATIONSHIPID")) {
                System.err
                        .println("First line of relationships input looks like a header line: "
                                + line);
            }

            if (line.trim().length() < 1) {
                continue;
            }
            int idx1 = line.indexOf('\t'); // 0..idx1 == relationshipid
            int idx2 = line.indexOf('\t', idx1 + 1); // idx1+1..idx2 ==
            // conceptid1
            int idx3 = line.indexOf('\t', idx2 + 1); // idx2+1..idx3 ==
            // RELATIONSHIPTYPE
            int idx4 = line.indexOf('\t', idx3 + 1); // idx3+1..idx4 ==
            // conceptid2
            int idx5 = line.indexOf('\t', idx4 + 1); // idx4+1..idx5 ==
            // CHARACTERISTICTYPE
            int idx6 = line.indexOf('\t', idx5 + 1); // idx5+1..idx6 ==
            // REFINABILITY
            int idx7 = line.indexOf('\t', idx6 + 1); // idx6+1..idx7 ==
            // RELATIONSHIPGROUP

            if (idx1 < 0 || idx2 < 0 || idx3 < 0 || idx4 < 0 || idx5 < 0
                    || idx6 < 0) {
                throw new RuntimeException(
                        "Relationships: Mis-formatted line, expected at least 7 tab-separated fields, got: "
                                + line);
            }

            // Ignore inactive relationships
            if (!"0".equals(line.substring(idx4 + 1, idx5))) {
                continue;
            }

            final String concept1 = line.substring(idx1 + 1, idx2);
            final String role = line.substring(idx2 + 1, idx3);
            final String concept2 = line.substring(idx3 + 1, idx4);

            final String group = idx7 < 0 ? line.substring(idx6 + 1) : line
                    .substring(idx6 + 1, idx7);

            result.add(new Rel(concept1, role, concept2, group));
        }

        return result;
    }
}

class Rel implements Comparable<Rel> {
    final String _c1, _r, _c2, _g;
    final String _hash;

    public Rel(String c1, String r, String c2, String g) {
        _c1 = c1.intern();
        _r = r.intern();
        _c2 = c2.intern();
        _g = g.intern();
        // _hash = _c1.hashCode() ^ _r.hashCode() ^ _c2.hashCode();
        _hash = _c1 + _r + _c2;
    }

    /**
     * Order based on _c1, _hash, _r, _c2
     */
    public int compareTo(Rel o) {
        final int hashCmp = _hash.compareTo(o._hash);
        // (int) (_hash - o._hash);
        return _c1.equals(o._c1) ? (_g.equals(o._g) ? (_r.equals(o._r) ? _c2
                .compareTo(o._c2) : _r.compareTo(o._r)) : ("0".equals(_g) ? -1
                : ("0".equals(o._g) ? 1 : hashCmp))) : _c1.compareTo(o._c1);
    }

    public String toString() {
        return _c1 + "\t" + _r + "\t" + _c2 + "\t" + _hash + "\t" + _g;
    }
}
