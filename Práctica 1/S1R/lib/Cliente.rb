# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
module Ruby
  class Cliente
    
    attr_accessor :bicicletas,:carreras,:factoria    

    
    
    def initialize 
      @bicicletas=Array.new
      @carreras=Array.new
      @codigo=0
    end
    
    def lee_entero(max,msg1,msg2)
      ok = false
      begin
        print msg1
        cadena = gets.chomp
        begin
          if (cadena =~ /\A\d+\Z/)
            numero = cadena.to_i
            ok = true
          else
            raise IOError
          end
        rescue IOError
          puts msg2
        end
        if (ok)
          if (numero >= max)
            ok = false
          end
        end
      end while (!ok)

      return numero
    end
    
    def menu(titulo,lista)
      tab = "  "
      puts titulo
      index = 0
      lista.each { |l|
        puts tab+index.to_s+"-"+l.to_s
        index += 1
      }

      opcion = lee_entero(lista.length,
                          "\n"+tab+"Elige una opción: ",
                          tab+"Valor erróneo")
      return opcion
    end
    
    
    def gestionar
      @opcion = -1
      @factoriaCreada = false
      @tipo 
           
      while @opcion != 0
        opciones = ["Terminar", "Construir factoria montania", "Construir factoria carretera"]
        @opcion = menu("¿Qué tipo de factoria quieres crear?",opciones)
        if @factoriaCreada == false
          case @opcion
          when 1
            factoria = FactoriaMontana.new
            @factoriaCreada=true
            @tipo=false
            
          when 2 
            factoria = FactoriaCarretera.new
            @factoriaCreada=true
            @tipo=true 
          end
        else
          if(factoriaCreada && !tipo)
            opciones = ["Terminar", "Generar participantes", "Crear carrera montania"]
            @opcion = menu("¿Qué desea hacer?",opciones)
             
          else
            if(factoriaCreada && tipo)
            opciones = ["Terminar", "Generar participantes", "Crear carrera carretera"]
            @opcion = menu("¿Qué desea hacer?",opciones)
            end
          end
          case @opcion
            when 1
              @bicicletas = generarParticipantes()
              puts "Participantes apuntados"
            when 2
              if(@bicicletas.length>0)
                carrera=@factoria.crearCarrera()
                carrera.codigo=@codigo
                @carreras<<carrera
                @codigo=@codigo+1
                
                @factoriaCreada=false
              else
                puts "Necesitas crear al menos una bicicleta"
              end
            end
          end
        end  
    end 
    
    def generarParticipantes
      bicis=Array.new 
      numPart=rand(1..10)+10
      for i in numPart
        bici=@factoria.crearBicicleta()
        bici.id=bici.id+i
        bicis<<bici
      end
    end
    
  end  
end