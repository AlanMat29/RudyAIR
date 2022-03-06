export class Compte {
  private _id: number | undefined;
  private _nom: string | undefined;
  private _prenom: string | undefined;
  private _dateNaissance: Date | undefined;
  private _email: string | undefined;
  private _password: string | undefined;

  constructor(
    id?: number,
    nom?: string,
    prenom?: string,
    dateNaissance?: Date,
    email?: string,
    password?: string
  ) {
    this._id = id;
    this._nom = nom;
    this._prenom = prenom;
    this._dateNaissance = dateNaissance;
    this._email = email;
    this._password = password;
  }

  /**
   * Getter id
   * @return {number }
   */
  public get id(): number | undefined {
    return this._id;
  }

  /**
   * Getter nom
   * @return {string }
   */
  public get nom(): string | undefined {
    return this._nom;
  }

  /**
   * Getter prenom
   * @return {string }
   */
  public get prenom(): string | undefined {
    return this._prenom;
  }

  /**
   * Getter dateNaissance
   * @return {Date }
   */
  public get dateNaissance(): Date | undefined {
    return this._dateNaissance;
  }

  /**
   * Getter email
   * @return {string }
   */
  public get email(): string | undefined {
    return this._email;
  }

  /**
   * Getter password
   * @return {string }
   */
  public get password(): string | undefined {
    return this._password;
  }

  /**
   * Setter id
   * @param {number } value
   */
  public set id(value: number | undefined) {
    this._id = value;
  }

  /**
   * Setter nom
   * @param {string } value
   */
  public set nom(value: string | undefined) {
    this._nom = value;
  }

  /**
   * Setter prenom
   * @param {string } value
   */
  public set prenom(value: string | undefined) {
    this._prenom = value;
  }

  /**
   * Setter dateNaissance
   * @param {Date } value
   */
  public set dateNaissance(value: Date | undefined) {
    this._dateNaissance = value;
  }

  /**
   * Setter email
   * @param {string } value
   */
  public set email(value: string | undefined) {
    this._email = value;
  }

  /**
   * Setter password
   * @param {string } value
   */
  public set password(value: string | undefined) {
    this._password = value;
  }
}
