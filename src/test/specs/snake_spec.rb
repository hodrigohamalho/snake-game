import org.rodrigoramalho.snakegame.model.Snake;
import org.rodrigoramalho.snakegame.model.Direcao;

describe Snake do
  
  before(:each) do
    @snake = Snake.new "3 5 5 NORTE"
  end

  context "com parametros válidos" do
  
    it "deveria receber o comprimento e as coordenadas iniciais" do
      @snake.comprimento.should == 3
      @snake.posicao.x.should == 5
      @snake.posicao.y.should == 5
      @snake.posicao.direcao.should == Direcao::NORTE
    end

  end

  context "com parametros invalidos" do
    it "direção inválida" do
      expect{ Snake.new "5 5 5 Rodrigo" }.should raise_error(java.lang.IllegalArgumentException)
    end
    
    it "comprimento negativo" do
      expect{ Snake.new "-5 5 5 NORTE" }.should raise_error(java.lang.IllegalArgumentException)
    end
    
    it "posicao x negativa" do
      expect{ Snake.new "5 -5 5 NORTE" }.should raise_error(java.lang.IllegalArgumentException)
    end
    
    it "posicao y negativa" do
      expect{ Snake.new "5 5 -5 NORTE" }.should raise_error(java.lang.IllegalArgumentException)
    end
  end
  
  context "movimentação" do
    context "com movimentos possiveis" do  
      it "deveria virar para esquerda quando estiver na direcao norte" do
        @snake.virarEsquerda();
        @snake.posicao.direcao.should == Direcao::OESTE
      end
      
      it "deveria virar para esquerda quando estiver na direcao sul" do
        @snake.posicao.direcao = Direcao::SUL
        @snake.virarEsquerda();
        @snake.posicao.direcao.should == Direcao::OESTE
      end
      
      it "deveria continuar apontando para esquerda ao tentar virar para esquerda" do
        @snake.posicao.direcao = Direcao::OESTE
        @snake.virarEsquerda();
        @snake.posicao.direcao.should == Direcao::OESTE
      end
      
      it "deveria virar para direita quando estiver na direcao norte" do
        @snake.virarDireita();
        @snake.posicao.direcao.should == Direcao::LESTE
      end
    end
    
    context "com movimentos impossíveis" do
      
      it 'quando apontando para o LESTE não deveria virar para a ESQUERDA' do
        @snake.posicao.direcao = Direcao::LESTE
        @snake.virarEsquerda();
        @snake.posicao.direcao.should == Direcao::LESTE
      end
      
    end    
  end

end
