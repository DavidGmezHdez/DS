# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
# encoding: UTF-8
require "io/console"
require_relative "FactoriaCarrerayBicicleta"
require_relative "FactoriaMontana"
require_relative "FactoriaCarretera"

module Ruby
  class Cliente
    
    attr_accessor :bicicletas,:carreras,:factoria    

    def initialize 
      @bicicletas=Array.new
      @carreras=Array.new
      @factoriaCreada=false
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
        "\n"+tab.to_s+"Elige una opcion: ", tab.to_s+"Valor erroneo")
      return opcion
    end
    
    
    def gestionar
      opcion = -1
           
      while opcion != 0
        
        if !@factoriaCreada
          opciones = ["Terminar", "Construir factoria montania", "Construir factoria carretera"]
          opcion = menu("Elige el tipo de factoria",opciones)
          case opcion
          when 1
            puts "Factoria de montana creada"
            @factoria = FactoriaMontana.new
            @factoriaCreada=true
            puts @factoriaCreada
            tipo=false
            
            
          when 2 
            puts "Factoria de carretera creada"
            @factoria = FactoriaCarretera.new
            @factoriaCreada=true
            puts @factoriaCreada
            tipo=true 
            puts tipo
          end
        else
          if(@factoriaCreada && !tipo)
            opciones = ["Terminar", "Generar participantes", "Crear carrera montania"]
            opcion = menu("Selecciona el siguiente paso",opciones)
             
          else
            if(@factoriaCreada && tipo)
            opciones = ["Terminar", "Generar participantes", "Crear carrera carretera"]
            opcion = menu("Selecciona el siguiente paso",opciones)
            end
          end
          case opcion
            when 1
              generarparticipantes
              puts "Participantes apuntados"
            when 2
              if(@bicicletas.length>0)
                
                @carreras.push(@factoria.crearCarrera(@codigo))
                @carreras[@codigo].aniadirparticipantes(@bicicletas)
                puts "Carrera creada"
                @codigo=@codigo+1
                
                @factoriaCreada=false
              else
                puts "Necesitas crear al menos una bicicleta"
              end
            end
          end
        end  
    end 
    
    def generarparticipantes
      numpart=rand(1..10)+20
      for i in 0..numpart.to_i
        bici=@factoria.crearBicicleta(i+1)
        @bicicletas.push(bici)
      end
    end
    
  end  
end