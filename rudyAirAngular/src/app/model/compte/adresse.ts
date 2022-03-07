export class Adresse {
  private _numero: string | undefined;
  private _voie: string | undefined;
  private _cp: string | undefined;
  private _ville: string | undefined;
  private _pays: string | undefined;

  constructor(
    numero: string,
    voie: string,
    cp: string,
    ville: string,
    pays: string
  ) {
    this._numero = numero;
    this._voie = voie;
    this._cp = cp;
    this._ville = ville;
    this._pays = pays;
  }

  /**
   * Getter numero
   * @return {string }
   */
  public get numero(): string | undefined {
    return this._numero;
  }

  /**
   * Getter voie
   * @return {string }
   */
  public get voie(): string | undefined {
    return this._voie;
  }

  /**
   * Getter cp
   * @return {string }
   */
  public get cp(): string | undefined {
    return this._cp;
  }

  /**
   * Getter ville
   * @return {string }
   */
  public get ville(): string | undefined {
    return this._ville;
  }

  /**
   * Getter pays
   * @return {string }
   */
  public get pays(): string | undefined {
    return this._pays;
  }

  /**
   * Setter numero
   * @param {string } value
   */
  public set numero(value: string | undefined) {
    this._numero = value;
  }

  /**
   * Setter voie
   * @param {string } value
   */
  public set voie(value: string | undefined) {
    this._voie = value;
  }

  /**
   * Setter cp
   * @param {string } value
   */
  public set cp(value: string | undefined) {
    this._cp = value;
  }

  /**
   * Setter ville
   * @param {string } value
   */
  public set ville(value: string | undefined) {
    this._ville = value;
  }

  /**
   * Setter pays
   * @param {string } value
   */
  public set pays(value: string | undefined) {
    this._pays = value;
  }
}
