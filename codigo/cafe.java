public CaféGrátis draco(Double doacaoAlunos, Pessoa você, CuidarDaCafeteira statusDaLimpeza){
            if(doacaoAlunos == 0){
                cafeteira.suprimentos == 0;
                cafeteira.cafeGratis == false;
            } else {
                cafeteira.suprimentos == 100;
                cafeteira.cafeGratis == true;
            }

            if(você.consomeCafe()){
                cafeteira.limpeza = você.limparCafeteira();
          
                if(você.desculpa = "mas quando eu cheguei já estava pronto, eu só bebi"){
                    nãoImporta.limpaMesmoAssim = true;
                }

                if(você.desculpa = "mas quando eu cheguei já estava sujo"){
                    nãoImporta.limpaMesmoAssim = true;
                    você.chamarAtençãoDeQuemDeixouSujo();
                } else {
                    nãoImporta.limpaMesmoAssim = true;
                }
            }

            if(cafeteira.limpeza == true){
                statusDaLimpeza--;
            } else {
                statusDaLimpeza++;
            }

            switch(statusDaLimpeza){
              case 2: cafeteira.delete();
               break;

              case 1: cafateira.suspender("2 semanas");
                break; 

              default: cafeteira.continua(true);
                break;
                
            }                            
}
