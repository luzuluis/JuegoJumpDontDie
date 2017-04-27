package com.jumpdontdie;

        import com.badlogic.gdx.Gdx;
        import com.badlogic.gdx.graphics.GL20;
        import com.badlogic.gdx.graphics.Texture;
        import com.badlogic.gdx.graphics.g2d.TextureRegion;
        import com.badlogic.gdx.scenes.scene2d.Stage;
        import com.jumpdontdie.actors.ActorCaja;
        import com.jumpdontdie.actors.ActorJugador;

/**
 * Created by Luis on 26/04/2017.
 */
public class MainGameScreen extends BaseScreen {
    private Stage stage;
    private ActorJugador jugador,jugador2;
    private ActorCaja caja;
    private Texture texturaJugador,texturaCaja;
    private TextureRegion regionCaja;


    public MainGameScreen(MainGame game) {

        super(game);
        texturaJugador=new Texture("mikey.png");
        texturaCaja=new Texture("caja.png");
        regionCaja=new TextureRegion(texturaCaja,0,30,128,98);
    }


    @Override
    public void show() {
        stage=new Stage();
        stage.setDebugAll(true);

        jugador=new ActorJugador(texturaJugador);
        jugador2=new ActorJugador(texturaCaja);
        caja=new ActorCaja(regionCaja);
        stage.addActor(jugador);
        stage.addActor(jugador2);
        stage.addActor(caja);
        jugador.setPosition(20,100);
        caja.setPosition(400,100);
        jugador2.setPosition(600,100);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.4f,0.8f,0.5f,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        comprobarColisiones();
        stage.draw();
    }

    private void comprobarColisiones() {
        if((jugador.isAlive())&&
                (jugador.getX()+jugador.getWidth()>caja.getX())){
            System.out.print("Colision de caja con Mikey!!");
            jugador.setAlive(false);
        }
    }

    @Override
    public void hide() {
        stage.dispose();
    }

    @Override
    public void dispose() {

        texturaJugador.dispose();
    }
}
