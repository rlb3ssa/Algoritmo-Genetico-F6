public CaféGrátis draco(Double doacaoAlunos, Pessoa você, CuidarDaCafeteira status){
                if(doacaoAlunos == 0){
                        cafeteira.suprimentos == 0;
                        cafeteira.cafeGratis == false;
                } else{
                        cafeteira.suprimentos == 100;
                        cafeteira.cafeGratis == true;
                }

                if(você.consomeCafe()){
                        cafeteira.limpeza = você.limparCafeteira();

                        if(desculpa = "mas quando eu cheguei já estava pronto, eu só bebi"){
                                nãoImporta.limpaMesmoAssim = true;
                                cafeteira.limpeza = você.limparCafeteira();
                        }

                        if(desculpa = "mas quando eu cheguei já estava sujo"){
                                nãoImporta.limpaMesmoAssim = true;
                                cafeteira.limpeza = você.limparCafeteira();
                                você.chamarAtençãoDeQuemDeixouSujo();
                        }
                }

                if(cafeteira.limpeza == true){
                        status--;
                }
                else{
                        status++;
                }

                if(status>1){
                        cafeteira.delete();
                }
                if( status == 1){
                        cafateira.suspender("2 semanas");
                }
                else{
                        cafeteira.continua(true);
                }
                
        }
