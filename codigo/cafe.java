public Draco cafeGratis(Double doacaoAlunos, Pessoa você, Boolean vaiTerQueDeletarCafeteira){
            if(vaiTerQueDeletarCafeteira){
                   cafeteira.delete();
                   system.shutdown();
            }
            
            if(doacaoAlunos == 0){
                   cafeteira.suprimentos = 0;
                   cafeteira.cafeGratis = false;
                   return false;
            } else {
                   cafeteira.suprimentos = 100;
                   cafeteira.cafeGratis = true;
            }

            if(você.consomeCafe()){
                   cafeteira.limpeza = você.limparCafeteira();
          
                   if(você.desculpa == "mas quando eu cheguei já estava pronto, eu só bebi"){
                       naoImporta.limpaMesmoAssim = true;
                   }

                   if(você.desculpa == "mas quando eu cheguei já estava sujo"){
                       naoImporta.limpaMesmoAssim = true;
                       você.chamarAtencaoDeQuemDeixouSujo();
                   } 
                               
                   else {
                       naoImporta.limpaMesmoAssim = true;
                   }          
            }

            if(cafeteira.limpeza == true){
                   vaiTerQueDeletarCafeteira = false;
            } 
            else {
                   vaiTerQueDeletarCafeteira = true;
            }
            
            return vaiTerQueDeletarCafeteira;
}
