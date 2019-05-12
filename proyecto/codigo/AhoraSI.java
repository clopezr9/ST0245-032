import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.lang.Math;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class AhoraSI {
    Map <String,Bee> bOrga = new HashMap<String,Bee>();
    public void main(int bQuantity){
        hashFunction(readFile(bQuantity), bQuantity);
    }

    private Bee[] readFile(int bQuantity){
        long start = System.currentTimeMillis();
        Bee [] Bees = new Bee[bQuantity];
        final String nombreDelArchivo = "ConjuntoDeDatosCon" + bQuantity + "abejas.txt";
        try {            
            BufferedReader br = new BufferedReader(new FileReader(nombreDelArchivo));
            String lineaActual = br.readLine();
            lineaActual = br.readLine(); // Descarta la primera linea
            int index = 0;
            if (index<bQuantity){
                while (lineaActual != null){ // Mientras no llegue al fin del archivo
                    String [] coordenates = lineaActual.split(",");
                    Bee bee = new Bee(Float.parseFloat(coordenates[0]) * (-111111.2f),
                            Float.parseFloat(coordenates[1]) * (111111.2f),
                            Float.parseFloat(coordenates[2]));
                    Bees[index] = bee;
                    lineaActual = br.readLine();
                    index++;
                }
            }
        }   catch(IOException ioe) {
            System.out.println("There's a problem with the file");
        }
        long end = System.currentTimeMillis() - start;
        Runtime m=Runtime.getRuntime();
        long memoriaUsada=(m.totalMemory()-m.freeMemory());
        System.out.println(end);
        System.out.println(memoriaUsada);
        return Bees;
    }

    private String toCubeString(int n, int m, int d) {
        return Integer.toString(n) + "-" + Integer.toString(m) + "-" + Integer.toString(d);
    }

    private void hashFunction (Bee [] bees, int bQuantity){
        long start = System.currentTimeMillis();
        final String fileName = "respuestaConjuntoDeDatosCon" + bQuantity + "abejas.txt";  
        float l = 57.0f;
        int length = bees.length;
        try{
            PrintWriter writer = new PrintWriter(fileName, "UTF-8");
            for(int i=0; i<length; i++){
                int n = (int)Math.round(bees[i].getX()/l);
                int m = (int)Math.round(bees[i].getY()/l);
                int d = (int)Math.round(bees[i].getZ()/l);

                String cubeString = toCubeString(n, m, d);

                if (bOrga.get(cubeString) == null) {
                    bOrga.put(cubeString, bees[i]);
                } else {
                    writer.println((bees[i].getX()/-111111.2)+ "," 
                        + (bees[i].getY()/111111.2)+ "," + bees[i].getZ());
                }
            }
            for(Map.Entry<String, Bee> entry: bOrga.entrySet()){
                String key = entry.getKey();
                String[] melo = key.split("-");
                checkAdjacentCubes(melo, key, writer);
            }
            writer.close();
        }
        catch(IOException ioe) {
            System.out.println("Error making new file");
        }  
        long end = System.currentTimeMillis() - start;
        Runtime m=Runtime.getRuntime();
        long memoriaUsada=(m.totalMemory()-m.freeMemory());
        System.out.println(end);
        System.out.println(memoriaUsada);
    }
    
    private void checkAdjacentCubes(String [] keys, String actKey, PrintWriter writer){
        int x = Integer.parseInt(keys[0]);
        int y = Integer.parseInt(keys[1]);
        int z = Integer.parseInt(keys[2]);

        if(bOrga.containsKey(toCubeString(x+1, y,z))){ //1
            Bee bee1 = bOrga.get(toCubeString(x+1, y,z));
            Bee bee2 = bOrga.get(actKey);
            if ((Math.abs(bee1.getX()-bee2.getX()))<= 100){
                if ((Math.abs(bee1.getY()-bee2.getY()))<= 100){
                    if ((Math.abs(bee1.getZ()-bee2.getZ()))<= 100){
                        writer.println(bee2.getX()/111111.2 + "," + bee2.getY()/111111.2 +","+ bee2.getZ());
                    }
                }
            }
        }else if(bOrga.containsKey(toCubeString(x+1,y+1 ,z))){ //2
            Bee bee1 = bOrga.get(toCubeString(x+1 ,y+1 ,z));
            Bee bee2 = bOrga.get(actKey);
            if ((Math.abs(bee1.getX()-bee2.getX()))<= 100){
                if ((Math.abs(bee1.getY()-bee2.getY()))<= 100){
                    if ((Math.abs(bee1.getZ()-bee2.getZ()))<= 100){
                        writer.println(bee2.getX()/111111.2 + "," + bee2.getY()/111111.2 +","+ bee2.getZ());
                    }
                }
            }
        }else if(bOrga.containsKey(toCubeString(x,y+1 ,z))){ //3
            Bee bee1 = bOrga.get(toCubeString(x,y+1 ,z));
            Bee bee2 = bOrga.get(actKey);
            if ((Math.abs(bee1.getX()-bee2.getX()))<= 100){
                if ((Math.abs(bee1.getY()-bee2.getY()))<= 100){
                    if ((Math.abs(bee1.getZ()-bee2.getZ()))<= 100){
                        writer.println(bee2.getX()/111111.2 + "," + bee2.getY()/111111.2 +","+ bee2.getZ());
                    }
                }
            }
        }else if(bOrga.containsKey(toCubeString(x-1,y+1 ,z))){  //4
            Bee bee1 = bOrga.get(toCubeString(x-1 ,y+1 ,z));
            Bee bee2 = bOrga.get(actKey);
            if ((Math.abs(bee1.getX()-bee2.getX()))<= 100){
                if ((Math.abs(bee1.getY()-bee2.getY()))<= 100){
                    if ((Math.abs(bee1.getZ()-bee2.getZ()))<= 100){
                        writer.println(bee2.getX()/111111.2 + "," + bee2.getY()/111111.2 +","+ bee2.getZ());
                    }
                }
            }
        }else if(bOrga.containsKey(toCubeString(x-1,y ,z))){  //5
            Bee bee1 = bOrga.get(toCubeString(x-1 ,y ,z));
            Bee bee2 = bOrga.get(actKey);
            if ((Math.abs(bee1.getX()-bee2.getX()))<= 100){
                if ((Math.abs(bee1.getY()-bee2.getY()))<= 100){
                    if ((Math.abs(bee1.getZ()-bee2.getZ()))<= 100){
                        writer.println(bee2.getX()/111111.2 + "," + bee2.getY()/111111.2 +","+ bee2.getZ());
                    }
                }
            }
        }else if(bOrga.containsKey(toCubeString(x-1,y-1 ,z))){   //6
            Bee bee1 = bOrga.get(toCubeString(x-1 ,y-1 ,z));
            Bee bee2 = bOrga.get(actKey);
            if ((Math.abs(bee1.getX()-bee2.getX()))<= 100){
                if ((Math.abs(bee1.getY()-bee2.getY()))<= 100){
                    if ((Math.abs(bee1.getZ()-bee2.getZ()))<= 100){
                        writer.println(bee2.getX()/111111.2 + "," + bee2.getY()/111111.2 +","+ bee2.getZ());
                    }
                }
            }
        }else if(bOrga.containsKey(toCubeString(x,y-1 ,z))){   //7
            Bee bee1 = bOrga.get(toCubeString(x,y-1 ,z));
            Bee bee2 = bOrga.get(actKey);
            if ((Math.abs(bee1.getX()-bee2.getX()))<= 100){
                if ((Math.abs(bee1.getY()-bee2.getY()))<= 100){
                    if ((Math.abs(bee1.getZ()-bee2.getZ()))<= 100){
                        writer.println(bee2.getX()/111111.2 + "," + bee2.getY()/111111.2 +","+ bee2.getZ());
                    }
                }
            }
        }else if(bOrga.containsKey(toCubeString(x+1,y-1 ,z))){  //8
            Bee bee1 = bOrga.get(toCubeString(x+1 ,y-1 ,z));
            Bee bee2 = bOrga.get(actKey);
            if ((Math.abs(bee1.getX()-bee2.getX()))<= 100){
                if ((Math.abs(bee1.getY()-bee2.getY()))<= 100){
                    if ((Math.abs(bee1.getZ()-bee2.getZ()))<= 100){
                        writer.println(bee2.getX()/111111.2 + "," + bee2.getY()/111111.2 +","+ bee2.getZ());
                    }
                }
            }
        }else if(bOrga.containsKey(toCubeString(x,y ,z+1))){ //9
            Bee bee1 = bOrga.get(toCubeString(x,y ,z+1));
            Bee bee2 = bOrga.get(actKey);
            if ((Math.abs(bee1.getX()-bee2.getX()))<= 100){
                if ((Math.abs(bee1.getY()-bee2.getY()))<= 100){
                    if ((Math.abs(bee1.getZ()-bee2.getZ()))<= 100){
                        writer.println(bee2.getX()/111111.2 + "," + bee2.getY()/111111.2 +","+ bee2.getZ());
                    }
                }
            }
        }else if(bOrga.containsKey(toCubeString(x+1,y ,z+1))){  //10
            Bee bee1 = bOrga.get(toCubeString(x+1 ,y ,z+1));
            Bee bee2 = bOrga.get(actKey);
            if ((Math.abs(bee1.getX()-bee2.getX()))<= 100){
                if ((Math.abs(bee1.getY()-bee2.getY()))<= 100){
                    if ((Math.abs(bee1.getZ()-bee2.getZ()))<= 100){
                        writer.println(bee2.getX()/111111.2 + "," + bee2.getY()/111111.2 +","+ bee2.getZ());
                    }
                }
            }
        } else if(bOrga.containsKey(toCubeString(x+1,y+1 ,z+1))){  //11
            Bee bee1 = bOrga.get(toCubeString(x+1 ,y+1 ,z+1));
            Bee bee2 = bOrga.get(actKey);
            if ((Math.abs(bee1.getX()-bee2.getX()))<= 100){
                if ((Math.abs(bee1.getY()-bee2.getY()))<= 100){
                    if ((Math.abs(bee1.getZ()-bee2.getZ()))<= 100){
                        writer.println(bee2.getX()/111111.2 + "," + bee2.getY()/111111.2 +","+ bee2.getZ());
                    }
                }
            }

        }else if(bOrga.containsKey(toCubeString(x,y+1 ,z+1))){  //12
            Bee bee1 = bOrga.get(toCubeString(x ,y+1 ,z+1));
            Bee bee2 = bOrga.get(actKey);
            if ((Math.abs(bee1.getX()-bee2.getX()))<= 100){
                if ((Math.abs(bee1.getY()-bee2.getY()))<= 100){
                    if ((Math.abs(bee1.getZ()-bee2.getZ()))<= 100){
                        writer.println(bee2.getX()/111111.2 + "," + bee2.getY()/111111.2 +","+ bee2.getZ());
                    }
                }
            }
        }else if(bOrga.containsKey(toCubeString(x+1,y-1 ,z+1))){  //13
            Bee bee1 = bOrga.get(toCubeString(x+1 ,y-1 ,z+1));
            Bee bee2 = bOrga.get(actKey);
            if ((Math.abs(bee1.getX()-bee2.getX()))<= 100){
                if ((Math.abs(bee1.getY()-bee2.getY()))<= 100){
                    if ((Math.abs(bee1.getZ()-bee2.getZ()))<= 100){
                        writer.println(bee2.getX()/111111.2 + "," + bee2.getY()/111111.2 +","+ bee2.getZ());
                    }
                }
            }
        }else if(bOrga.containsKey(toCubeString(x,y-1 ,z+1))){  //14
            Bee bee1 = bOrga.get(toCubeString(x,y-1 ,z+1));
            Bee bee2 = bOrga.get(actKey);
            if ((Math.abs(bee1.getX()-bee2.getX()))<= 100){
                if ((Math.abs(bee1.getY()-bee2.getY()))<= 100){
                    if ((Math.abs(bee1.getZ()-bee2.getZ()))<= 100){
                        writer.println(bee2.getX()/111111.2 + "," + bee2.getY()/111111.2 +","+ bee2.getZ());
                    }
                }
            }
        }else if(bOrga.containsKey(toCubeString(x-1,y-1 ,z+1))){  //15
            Bee bee1 = bOrga.get(toCubeString(x-1 ,y-1 ,z+1));
            Bee bee2 = bOrga.get(actKey);
            if ((Math.abs(bee1.getX()-bee2.getX()))<= 100){
                if ((Math.abs(bee1.getY()-bee2.getY()))<= 100){
                    if ((Math.abs(bee1.getZ()-bee2.getZ()))<= 100){
                        writer.println(bee2.getX()/111111.2 + "," + bee2.getY()/111111.2 +","+ bee2.getZ());
                    }
                }
            }
        }else if(bOrga.containsKey(toCubeString(x-1,y ,z+1))){  //16
            Bee bee1 = bOrga.get(toCubeString(x-1 ,y ,z+1));
            Bee bee2 = bOrga.get(actKey);
            if ((Math.abs(bee1.getX()-bee2.getX()))<= 100){
                if ((Math.abs(bee1.getY()-bee2.getY()))<= 100){
                    if ((Math.abs(bee1.getZ()-bee2.getZ()))<= 100){
                        writer.println(bee2.getX()/111111.2 + "," + bee2.getY()/111111.2 +","+ bee2.getZ());
                    }
                }
            }
        }else if(bOrga.containsKey(toCubeString(x+1,y-1 ,z+1))){  //17
            Bee bee1 = bOrga.get(toCubeString(x+1 ,y-1 ,z+1));
            Bee bee2 = bOrga.get(actKey);
            if ((Math.abs(bee1.getX()-bee2.getX()))<= 100){
                if ((Math.abs(bee1.getY()-bee2.getY()))<= 100){
                    if ((Math.abs(bee1.getZ()-bee2.getZ()))<= 100){
                        writer.println(bee2.getX()/111111.2 + "," + bee2.getY()/111111.2 +","+ bee2.getZ());
                    }
                }
            }
        }else if(bOrga.containsKey(toCubeString(x,y ,z-1))){ //18
            Bee bee1 = bOrga.get(toCubeString(x,y ,z-1));
            Bee bee2 = bOrga.get(actKey);
            if ((Math.abs(bee1.getX()-bee2.getX()))<= 100){
                if ((Math.abs(bee1.getY()-bee2.getY()))<= 100){
                    if ((Math.abs(bee1.getZ()-bee2.getZ()))<= 100){
                        writer.println(bee2.getX()/111111.2 + "," + bee2.getY()/111111.2 +","+ bee2.getZ());
                    }
                }
            }
        }else if(bOrga.containsKey(toCubeString(x+1,y ,z-1))){  //19
            Bee bee1 = bOrga.get(toCubeString(x+1 ,y ,z-1));
            Bee bee2 = bOrga.get(actKey);
            if ((Math.abs(bee1.getX()-bee2.getX()))<= 100){
                if ((Math.abs(bee1.getY()-bee2.getY()))<= 100){
                    if ((Math.abs(bee1.getZ()-bee2.getZ()))<= 100){
                        writer.println(bee2.getX()/111111.2 + "," + bee2.getY()/111111.2 +","+ bee2.getZ());
                    }
                }
            }
        } else if(bOrga.containsKey(toCubeString(x+1,y+1 ,z-1))){  //20
            Bee bee1 = bOrga.get(toCubeString(x+1 ,y+1 ,z-1));
            Bee bee2 = bOrga.get(actKey);
            if ((Math.abs(bee1.getX()-bee2.getX()))<= 100){
                if ((Math.abs(bee1.getY()-bee2.getY()))<= 100){
                    if ((Math.abs(bee1.getZ()-bee2.getZ()))<= 100){
                        writer.println(bee2.getX()/111111.2 + "," + bee2.getY()/111111.2 +","+ bee2.getZ());
                    }
                }
            }

        }else if(bOrga.containsKey(toCubeString(x,y+1 ,z-1))){  //21
            Bee bee1 = bOrga.get(toCubeString(x ,y+1 ,z-1));
            Bee bee2 = bOrga.get(actKey);
            if ((Math.abs(bee1.getX()-bee2.getX()))<= 100){
                if ((Math.abs(bee1.getY()-bee2.getY()))<= 100){
                    if ((Math.abs(bee1.getZ()-bee2.getZ()))<= 100){
                        writer.println(bee2.getX()/111111.2 + "," + bee2.getY()/111111.2 +","+ bee2.getZ());
                    }
                }
            }
        }else if(bOrga.containsKey(toCubeString(x+1,y-1 ,z-1))){  //22
            Bee bee1 = bOrga.get(toCubeString(x+1 ,y-1 ,z-1));
            Bee bee2 = bOrga.get(actKey);
            if ((Math.abs(bee1.getX()-bee2.getX()))<= 100){
                if ((Math.abs(bee1.getY()-bee2.getY()))<= 100){
                    if ((Math.abs(bee1.getZ()-bee2.getZ()))<= 100){
                        writer.println(bee2.getX()/111111.2 + "," + bee2.getY()/111111.2 +","+ bee2.getZ());
                    }
                }
            }
        }else if(bOrga.containsKey(toCubeString(x,y-1 ,z-1))){  //23
            Bee bee1 = bOrga.get(toCubeString(x,y-1 ,z-1));
            Bee bee2 = bOrga.get(actKey);
            if ((Math.abs(bee1.getX()-bee2.getX()))<= 100){
                if ((Math.abs(bee1.getY()-bee2.getY()))<= 100){
                    if ((Math.abs(bee1.getZ()-bee2.getZ()))<= 100){
                        writer.println(bee2.getX()/111111.2 + "," + bee2.getY()/111111.2 +","+ bee2.getZ());
                    }
                }
            }
        }else if(bOrga.containsKey(toCubeString(x-1,y-1 ,z-1))){  //24
            Bee bee1 = bOrga.get(toCubeString(x-1 ,y-1 ,z-1));
            Bee bee2 = bOrga.get(actKey);
            if ((Math.abs(bee1.getX()-bee2.getX()))<= 100){
                if ((Math.abs(bee1.getY()-bee2.getY()))<= 100){
                    if ((Math.abs(bee1.getZ()-bee2.getZ()))<= 100){
                        writer.println(bee2.getX()/111111.2 + "," + bee2.getY()/111111.2 +","+ bee2.getZ());
                    }
                }
            }
        }else if(bOrga.containsKey(toCubeString(x-1,y ,z-1))){  //25
            Bee bee1 = bOrga.get(toCubeString(x-1 ,y ,z-1));
            Bee bee2 = bOrga.get(actKey);
            if ((Math.abs(bee1.getX()-bee2.getX()))<= 100){
                if ((Math.abs(bee1.getY()-bee2.getY()))<= 100){
                    if ((Math.abs(bee1.getZ()-bee2.getZ()))<= 100){
                        writer.println(bee2.getX()/111111.2 + "," + bee2.getY()/111111.2 +","+ bee2.getZ());
                    }
                }
            }
        }else if(bOrga.containsKey(toCubeString(x+1,y-1 ,z-1))){  //26
            Bee bee1 = bOrga.get(toCubeString(x+1 ,y-1 ,z-1));
            Bee bee2 = bOrga.get(actKey);
            if ((Math.abs(bee1.getX()-bee2.getX()))<= 100){
                if ((Math.abs(bee1.getY()-bee2.getY()))<= 100){
                    if ((Math.abs(bee1.getZ()-bee2.getZ()))<= 100){
                        writer.println(bee2.getX()/111111.2 + "," + bee2.getY()/111111.2 +","+ bee2.getZ());
                    }
                }
            }
        }
        
    }
}

